package com.vincent.web3j_demo.utils;

import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.ECPointUtil;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.jce.spec.ECParameterSpec;

import java.math.BigInteger;
import java.security.*;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;

/**
 * author vincent
 * create at 2022/7/5
 * Description
 **/
public class EcdsaUtils {

    private static final String ALGORITHM = "secp256r1";

    private static final X9ECParameters CURVE_PARAMS = CustomNamedCurves.getByName(ALGORITHM);
    private static final ECDomainParameters CURVE = new ECDomainParameters(CURVE_PARAMS.getCurve(), CURVE_PARAMS.getG(), CURVE_PARAMS.getN(), CURVE_PARAMS.getH());

    private final static ECParameterSpec SPEC = ECNamedCurveTable.getParameterSpec(ALGORITHM);


    /**
     * 根据私钥byte数组生成ECDSA签名私钥:get privateKey
     *
     * @param privateKey
     * @return
     */
    public static ECPrivateKey generatePrivateKey(byte[] privateKey) throws Exception {

        KeyFactory kf = KeyFactory.getInstance("EC", new BouncyCastleProvider());
        ECNamedCurveSpec params = new ECNamedCurveSpec(ALGORITHM, SPEC.getCurve(), SPEC.getG(), SPEC.getN());

        ECPrivateKeySpec privateKeySpec = new ECPrivateKeySpec(new BigInteger(privateKey), params);

        return (ECPrivateKey) kf.generatePrivate(privateKeySpec);
    }

    public static PublicKey getPublicKeyFromBytes(byte[] pubKey) throws Exception {
        ECNamedCurveParameterSpec spec = ECNamedCurveTable.getParameterSpec("prime256v1");
        KeyFactory kf = KeyFactory.getInstance("EC", new BouncyCastleProvider());
        ECNamedCurveSpec params = new ECNamedCurveSpec("prime256v1", spec.getCurve(), spec.getG(), spec.getN());
        ECPoint point = ECPointUtil.decodePoint(params.getCurve(), pubKey);
        ECPublicKeySpec pubKeySpec = new ECPublicKeySpec(point, params);
        ECPublicKey pk = (ECPublicKey) kf.generatePublic(pubKeySpec);
        return pk;
    }

    /**
     * 生成密钥对:generate public and private key
     *
     * @return
     */
    public static void generateKeyPair() {

        ECKeyPairGenerator generator = new ECKeyPairGenerator();
        ECKeyGenerationParameters keygenParams = new ECKeyGenerationParameters(CURVE, new SecureRandom());

        generator.init(keygenParams);

        AsymmetricCipherKeyPair keypair = generator.generateKeyPair();

        ECPrivateKeyParameters privateParams = (ECPrivateKeyParameters) keypair.getPrivate();
        ECPublicKeyParameters publicParams = (ECPublicKeyParameters) keypair.getPublic();

        BigInteger privateParamsD = privateParams.getD();

        System.out.println("private: " + HexUtil.encodeHexString(privateParamsD.toByteArray()));

        byte[] encoded = publicParams.getQ().getEncoded(true);
        System.out.println("public: " + HexUtil.encodeHexString(encoded));

    }


    /**
     * 签名内容:sign message
     *
     * @return
     */

    public static String sign(byte[] message, PrivateKey eckey) throws Exception {

        Signature dsa = Signature.getInstance("SHA256withECDSA");

        dsa.initSign(eckey);
        dsa.update(message);

        return HexUtil.encodeHexString(dsa.sign());
    }

    public static boolean verify(PublicKey publicKey, String signature, byte[] message) throws Exception {
        Signature dsa = Signature.getInstance("SHA256withECDSA");
        dsa.initVerify(publicKey);
        dsa.update(message);
        boolean bool = dsa.verify(HexUtil.decode(signature));
        return bool;
    }

    public static void main(String[] args) throws Exception {
//        String pub = "03b385a4a34d9319cfac55b7897d317c7b323b888aa29fb51c839a393c81e87468";
//        String pri = "00a8f06bf52ce0ab1ece8322c5c8275ee22aa997bc8570eabbd1d9fe2badb8e654";
//
//        String message = "POST|/api/v2/keygen|1657159197390|{\"curve\":\"secp256r1\",\"node_count\":3,\"threshold\":2,\"vault_name\":\"test\"}";
//        byte[] signByte = DigestUtils.sha256(message);
//        String origin = HexUtil.encodeHexString(signByte);
////        String sign = sign(HexUtil.decode(origin), generatePrivateKey(HexUtil.decode(pri)));
//        String sign = "3046022100a6240d542c17fa186ddcd989449850725426d3c55d3d9629d584aea64ba07663022100d83088cf6513b7d01a6d960c571b3153ca070968cb4c5ff65c86a859eeeac08b";
//        System.out.println("signature:" + sign);
//
//        boolean verify = verify(getPublicKeyFromBytes(HexUtil.decode(pub)), sign, signByte);
//        System.out.println("verify:" + verify);

        generateKeyPair();

//        String packMsg = "POST|/api/v2/keygen|1657159197390|{\"curve\":\"secp256r1\",\"node_count\":3,\"threshold\":2,\"vault_name\":\"test\"}";
//        byte[] signByte = DigestUtils.sha256(packMsg);
//        String origin = HexUtil.encodeHexString(signByte);
//        System.out.println(origin);

        HexUtil.decode("0398c5929bc3fd5744d6ba86d0379e073456339f98f9c5475d331d657edc52d909");
        System.out.println("0398c5929bc3fd5744d6ba86d0379e073456339f98f9c5475d331d657edc52d909：length=" + "0398c5929bc3fd5744d6ba86d0379e073456339f98f9c5475d331d657edc52d909".length());
    }
}
