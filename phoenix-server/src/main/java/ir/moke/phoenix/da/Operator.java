package ir.moke.phoenix.da;

import ir.moke.phoenix.factory.JsonBuilderFactory;
import oracle.kv.*;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import java.io.StringReader;
import java.util.Iterator;

public class Operator {

    private static final JsonReader EMPTY_RESPONSE = Json.createReader(new StringReader("{}"));
    private JsonObjectBuilder builder;

    private KVStore store;

    public Operator(KVStore kvStore) {
        this.builder = JsonBuilderFactory.instance.getBuilder();
        this.store = kvStore;
    }

    public JsonObject saveOrUpdate(String path, String data) {
        Key key = Key.fromString(path);
        Value value = Value.createValue(data.getBytes());
        Version version = store.put(key, value);
        return builder.add(path, version.getRepGroupUUID().toString()).build();
    }

    public void delete(String path) {
        Key key = Key.fromString(path);
        store.delete(key);
    }

    public void deleteRecursive(String path) {
        Key key = Key.fromString(path);
        store.multiDelete(key, null, null);
    }

    public JsonObject select(String path) {
        Key key = Key.fromString(path);
        JsonReader reader;
        try {
            byte[] bytes = store.get(key).getValue().getValue();
            String result = new String(bytes);
            reader = Json.createReader(new StringReader(result));
        } catch (Exception e) {
            reader = EMPTY_RESPONSE;

        }
        return builder.add(path, reader.readObject()).build();
    }

    public JsonObject selectAll(String path) {
        Key key = Key.fromString(path);
        Iterator<KeyValueVersion> kvi = store.multiGetIterator(Direction.FORWARD, 0, key, null, null);
        return marshalObject(kvi);
    }

    public JsonObject selectByRange(String path, String start, String end) {
        Key key = Key.fromString(path);
        Iterator<KeyValueVersion> kvi = store.multiGetIterator(Direction.FORWARD, 0, key, new KeyRange(start, true, end, true), null);
        return marshalObject(kvi);
    }

    private JsonObject marshalObject(Iterator<KeyValueVersion> kvi) {
        while (kvi.hasNext()) {
            KeyValueVersion keyValueVersion = kvi.next();
            String k = keyValueVersion.getKey().toString();
            String v = new String(keyValueVersion.getValue().getValue());
            JsonReader jsonReader = Json.createReader(new StringReader(v));
            builder.add(k, jsonReader.readObject());
        }
        return builder.build();
    }
}
