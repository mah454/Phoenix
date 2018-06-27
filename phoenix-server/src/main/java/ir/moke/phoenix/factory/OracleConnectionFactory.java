package ir.moke.phoenix.factory;

import ir.moke.phoenix.da.Operator;
import oracle.kv.KVStore;
import oracle.kv.KVStoreConfig;
import oracle.kv.KVStoreFactory;

public class OracleConnectionFactory implements ConnectionFactory {

    private static KVStoreConfig config;
    private static final OracleConnectionFactory ORACLE_CONNECTION_FACTORY = new OracleConnectionFactory();

    public static ConnectionFactory getConnection(String storeName, String urlConnection) {
        config = new KVStoreConfig(storeName, urlConnection);
        return ORACLE_CONNECTION_FACTORY;
    }

    public KVStore getKvStore() {
        return KVStoreFactory.getStore(config);
    }

    public Operator getOperator() {
        return new Operator(getKvStore());
    }
}
