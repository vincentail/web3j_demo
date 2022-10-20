package com.vincent.web3j_demo.demo;

import com.vincent.web3j_demo.utils.HexUtil;
import lombok.extern.slf4j.Slf4j;
import org.web3j.abi.TypeEncoder;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Hash;

import java.nio.charset.StandardCharsets;

/**
 * author vincent
 * create at 2022/10/20
 * Description
 **/
@Slf4j
public class HashDemo {
    private static final String HEX_PREFIX = "0x";
    private static String keccak256(String message) {
        if (message.startsWith(HEX_PREFIX)) {
            message = message.replaceFirst(HEX_PREFIX, "");
        }
        String messageKeccak256 = Hash.sha3(message);
        String prefixEncode = TypeEncoder.encodePacked(new Utf8String("\u0019Ethereum Signed Message:\n"));
        String messageLengthStr = HexUtil.decode(messageKeccak256.replaceAll(HEX_PREFIX, "")).length + "";
        String messageLengthEncode = HexUtil.encodeHexString(messageLengthStr.getBytes(StandardCharsets.UTF_8));

        String concat = prefixEncode + messageLengthEncode + messageKeccak256;
        String hash = Hash.sha3(concat.replaceAll(HEX_PREFIX, ""));
        log.info("keccak256 origin message:{} hash:{}", message, hash);
        return hash.replaceFirst(HEX_PREFIX, "");
    }
}
