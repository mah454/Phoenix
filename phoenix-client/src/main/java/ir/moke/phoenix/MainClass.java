package ir.moke.phoenix;

import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.MediaType;
import java.io.IOException;

public class MainClass {

    private static final String STORE_NAME = "phoenix";
    private static final String URL_CONNECTION = "localhost:5000";

    public static void main(String[] args) throws IOException {

        String key = "/sample" ;

        //language=JSON
        String u = "{\"username\":\"admin\",\"password\":\"111111\"}";

        User user = new User() ;
        user.setUsername("admin");
        user.setPassword("11");
        String response = WebClient.create("http://localhost:8080/api/v1/users/login")
                .type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(u)
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
