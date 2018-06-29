package ir.moke.phoenix.utils;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class SimpleKeyGenerator implements KeyGenerator {

    @Override
    public Key generateKey() {
        String keyString = "simpleKey" ;
        Key key = new SecretKeySpec(keyString.getBytes(),0,keyString.getBytes().length,"DES");
        return key ;
    }
}
