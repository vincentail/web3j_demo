package com.vincent.web3j_demo.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 16进制字符串与byte数组转换
 * @author vincent
 *
 */
public final class HexUtil {
    private static final char[] HEX = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public HexUtil() {
    }

    /**
     * byte数组转16进制字符串:byte convert to hex string
     * @param bytes
     * @return
     */
    public static String encodeHexString(byte[] bytes) {
        int nBytes = bytes.length;
        char[] result = new char[2 * nBytes];
        int j = 0;
        byte[] var4 = bytes;
        int var5 = bytes.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            byte aByte = var4[var6];
            result[j++] = HEX[(240 & aByte) >>> 4];
            result[j++] = HEX[15 & aByte];
        }

        return new String(result);
    }

    /**
     * 16进制字符串转byte数组:hex string convert to byte
     * @param s 字符串
     * @return
     */
    public static byte[] decode(CharSequence s) {
        int nChars = s.length();
        if (nChars % 2 != 0) {
            throw new IllegalArgumentException("Hex-encoded string must have an even number of characters");
        } else {
            byte[] result = new byte[nChars / 2];

            for(int i = 0; i < nChars; i += 2) {
                int msb = Character.digit(s.charAt(i), 16);
                int lsb = Character.digit(s.charAt(i + 1), 16);
                if (msb < 0 || lsb < 0) {
                    throw new IllegalArgumentException("Detected a Non-hex character at " + (i + 1) + " or " + (i + 2) + " position");
                }

                result[i / 2] = (byte)(msb << 4 | lsb);
            }

            return result;
        }
    }


    public static void main(String[] args) {
        String mess = "3045022100f08a09f55fe903bc9280ddba415cc4cf05255f610f1e91ebd6b7baa0cf127efe02203619c39f10f1d689322d96c09c99ddf895fe6fccde6cb327730cc329b123736c";
        System.out.println(mess);
        String mess2 = "POST|/api/v2/keygen|1657109887116|{\"curve\":\"secp256r1\",\"node_count\":3,\"threshold\":2,\"vault_name\":\"test\"}";
        byte[] bytes = DigestUtils.sha256(mess2);
        System.out.println(HexUtil.encodeHexString(bytes));
    }

}