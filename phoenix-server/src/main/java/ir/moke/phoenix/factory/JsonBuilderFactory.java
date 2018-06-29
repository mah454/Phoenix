package ir.moke.phoenix.factory;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

public class JsonBuilderFactory {

    public static JsonBuilderFactory instance = new JsonBuilderFactory();
    private JsonObjectBuilder builder;

    private JsonBuilderFactory() {
        this.builder = Json.createObjectBuilder();
    }

    public JsonObjectBuilder getBuilder() {
        return this.builder;
    }
}
