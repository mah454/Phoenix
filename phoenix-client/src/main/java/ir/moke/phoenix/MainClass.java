package ir.moke.phoenix;

import ir.moke.phoenix.da.Keya;
import ir.moke.phoenix.da.Operator;
import ir.moke.phoenix.factory.PhoenixConnectionFactory;
import ir.moke.phoenix.factory.PhoenixFactory;
import oracle.kv.KVStore;
import oracle.kv.Key;
import oracle.kv.ValueVersion;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import javax.json.spi.JsonProvider;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class MainClass {

    private static final String STORE_NAME = "phoenix";
    private static final String URL_CONNECTION = "localhost:5000";

    public static void main(String[] args) throws IOException {

        String key = "/sample" ;

        Keya a = new Keya() ;
        a.setKey("/sample");
        String response = WebClient.create("http://localhost:8080/api/v1/phoenix/aaaaa")
                .type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(a)
                .readEntity(String.class);
        System.out.println(response);

//        PhoenixFactory factory = PhoenixConnectionFactory.getConnection(STORE_NAME, URL_CONNECTION);
//        Operator operator = factory.getOperator();

//        operator.saveOrUpdate("/mah454", "{\"name\":\"Ali\"}");
//        operator.saveOrUpdate("/mah454/-/book/1", "{\"name\":\"Ebn Sina\"}");
//        operator.saveOrUpdate("/mah454/-/book/2", "{\"name\":\"Step Step to see god\"}");
//        operator.saveOrUpdate("/mah454/-/persons/1", "{\"name\":\"Ali\"}");
//        operator.saveOrUpdate("/mah454/-/persons/2", "{\"name\":\"Sina\"}");
//        operator.saveOrUpdate("/mah454/-/persons/3", "{\"name\":\"Mina\"}");
//        operator.saveOrUpdate("/mah454/-/persons/4", "{\"name\":\"Mahdi\"}");
//        operator.saveOrUpdate("/mah454/-/persons/5", "{\"name\":\"Javad\"}");
//        operator.saveOrUpdate("/mah454/-/persons/6", "{\"name\":\"Hassan\"}");
//        operator.saveOrUpdate("/mah454/-/persons/7", "{\"name\":\"Vaheid\"}");


//        operator.delete("/mah454");
//        operator.deleteRecursive("/mah454");

//        Map<String, String> map = operator.selectAll("/mah454");
//        map.forEach((key, value) -> System.out.println(key + "->>" + value));


//        SortedMap<Key,ValueVersion> sortedMap = operator.selectByRange("/mah454/-/persons","3","6");
//        Set<Map.Entry<Key,ValueVersion>> entries = sortedMap.entrySet();
//        entries.forEach(e-> {
//            System.out.println(e.getKey().getFullPath());
//            System.out.println(new String(e.getValue().getValue().getValue()));
//        });

    }
}
