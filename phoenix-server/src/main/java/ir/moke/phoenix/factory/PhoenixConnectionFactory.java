package ir.moke.phoenix.factory;

import ir.moke.phoenix.da.Operator;
import oracle.kv.KVStore;
import oracle.kv.KVStoreConfig;
import oracle.kv.KVStoreFactory;

public class PhoenixConnectionFactory implements PhoenixFactory {

    private static KVStore store ;
    private static final PhoenixConnectionFactory PHOENIX_CONNECTION_FACTORY= new PhoenixConnectionFactory();

    public static PhoenixFactory getConnection(String storeName, String urlConnection) {
        KVStoreConfig config = new KVStoreConfig(storeName, urlConnection);
        store = KVStoreFactory.getStore(config);
        return PHOENIX_CONNECTION_FACTORY ;
    }

    public KVStore getKvStore() {
        return store ;
    }

    public Operator getOperator() {
        return new Operator(getKvStore());
    }

    @Override
    public void close() {
        store.close();
    }
}
