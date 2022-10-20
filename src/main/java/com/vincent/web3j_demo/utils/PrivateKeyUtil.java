package com.vincent.web3j_demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.interfaces.ECPrivateKey;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author vincent
 * create at 2022/7/13
 * Description
 **/
@Slf4j
public class PrivateKeyUtil {
    private static final Map<String, ECPrivateKey> PRIVATE_KEY_MAP = new ConcurrentHashMap<>();

    public static ECPrivateKey getPrivateKey(String pri) throws Exception {
        ECPrivateKey privateKey = PRIVATE_KEY_MAP.get(pri);
        if (privateKey == null) {
            synchronized (pri) {
                privateKey = EcdsaUtils.generatePrivateKey(HexUtil.decode(pri));
                PRIVATE_KEY_MAP.put(pri,privateKey);
            }
        }
        return privateKey;
    }
}
