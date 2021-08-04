package com.easyrent.utils;

import org.apache.commons.codec.binary.Base64;
import java.security.*;

public class RsaUtils {
    public static String generateKey(){
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("rsa");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey aPrivate = keyPair.getPrivate();
        PublicKey aPublic = keyPair.getPublic();
        byte[] bytes1 =  Base64.encodeBase64(aPrivate.getEncoded());
        return new String(bytes1);

    }
}