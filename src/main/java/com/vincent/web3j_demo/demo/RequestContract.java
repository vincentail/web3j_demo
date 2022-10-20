package com.vincent.web3j_demo.demo;

import com.vincent.web3j_demo.contract.RequesterAuthorizerWithAirnode;
import com.vincent.web3j_demo.utils.HexUtil;
import org.web3j.crypto.Bip44WalletUtils;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;
import java.util.Date;

/**
 * author vincent
 * create at 2022/10/20
 * Description
 **/
public class RequestContract {
    private TransactionReceipt doTransaction(String endpointId, String requester, Date expireTime,String mnemonic) throws Exception {
        Web3j web3j = Web3j.build(new HttpService(""));
        Credentials credentials = Bip44WalletUtils.loadBip44Credentials("", mnemonic);
        //手续费
        BigInteger gasPrice;
        EthGasPrice ethGasPrice = web3j.ethGasPrice().sendAsync().get();
        if (ethGasPrice == null) {
            throw new Exception("can't get eth gas price");
        }
        gasPrice = ethGasPrice.getGasPrice();
        //注意手续费的设置，这块很容易遇到问题
        BigInteger gasLimit = BigInteger.valueOf(200000L);
        RequesterAuthorizerWithAirnode requesterAuthorizerWithAirnode = RequesterAuthorizerWithAirnode.load("contract address", web3j, credentials, gasPrice, gasLimit);
        if (endpointId.startsWith("0x")) {
            endpointId = endpointId.replace("0x", "");
        }
        long time = expireTime.getTime() / 1000;
        BigInteger expireTimestamp = new BigInteger(String.valueOf(time));
        RemoteFunctionCall<TransactionReceipt> receiptRemoteFunctionCall = requesterAuthorizerWithAirnode.setWhitelistExpiration("airnodeAddress", HexUtil.decode(endpointId), requester, expireTimestamp);
        return receiptRemoteFunctionCall.send();
    }

}
