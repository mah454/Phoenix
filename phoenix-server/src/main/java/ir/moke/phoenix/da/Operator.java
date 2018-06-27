package ir.moke.phoenix.da;

import oracle.kv.*;

import java.util.SortedMap;

public class Operator {

    private KVStore store;

    public Operator(KVStore kvStore) {
        this.store = kvStore;
    }

    public Version saveOrUpdate(String path, String data) {
        Key key = Key.fromString(path);
        Value value = Value.createValue(data.getBytes());
        return store.put(key, value);
    }

    public void delete(String path) {
        Key key = Key.fromString(path);
        store.delete(key);
    }

    public void deleteRecursive(String path) {
        Key key = Key.fromString(path);
        store.multiDelete(key, null, null);
    }

    public Value select(String path) {
        Key key = Key.fromString(path);
        return store.get(key).getValue();
    }

    public SortedMap<Key, ValueVersion> selectAll(String path) {
        Key key = Key.fromString(path);
        return store.multiGet(key,null,null);
    }

    public SortedMap<Key, ValueVersion> selectByRange(String path,String start,String end) {
        Key key = Key.fromString(path);
        return store.multiGet(key,new KeyRange(start,true,end,true),null);
    }
}
