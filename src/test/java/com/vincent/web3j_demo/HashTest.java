package com.vincent.web3j_demo;

import com.vincent.web3j_demo.utils.HexUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.web3j.crypto.Hash;

/**
 * author vincent
 * create at 2022/10/20
 * Description
 **/
@Slf4j
public class HashTest {

    @Test
    public void testSha256() {
        String msg = "withdraw(uint256)";

        String s = Hash.sha3(HexUtil.encodeHexString(msg.getBytes()));
        log.info("hash {}", s);
    }
}
