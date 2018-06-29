package ir.moke.phoenix.utils;

import oracle.kv.Key;

public class StoreUtils {
    public static final StoreUtils utils = new StoreUtils();

    private StoreUtils() {
    }

    public String getMinorPath(Key key) {
        return key.toString().replaceFirst(".*\\/-", "");
    }
}
