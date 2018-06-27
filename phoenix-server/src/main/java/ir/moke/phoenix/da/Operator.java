package ir.moke.phoenix.da;

import oracle.kv.*;

import java.util.HashMap;
import java.util.Map;
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

    public Map<Key, Value> selectAll(String path) {
        Map<Key, Value> map = new HashMap<>();
        Key key = Key.fromString(path);
        SortedMap<Key, ValueVersion> sortedMap = store.multiGet(key, null, null);
        sortedMap.forEach((k, v) -> map.put(k, v.getValue()));
        return map;
    }

    public SortedMap<Key, ValueVersion> selectByRange(String path, String start, String end) {
        Key key = Key.fromString(path);
        return store.multiGet(key, new KeyRange(start, true, end, true), null);
    }
}
