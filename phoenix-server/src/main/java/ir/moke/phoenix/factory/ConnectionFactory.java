package ir.moke.phoenix.factory;

import ir.moke.phoenix.da.Operator;
import oracle.kv.KVStore;

public interface ConnectionFactory {

    KVStore getKvStore() ;
    Operator getOperator() ;
}
