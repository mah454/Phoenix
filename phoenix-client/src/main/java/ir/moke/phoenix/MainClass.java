package ir.moke.phoenix;

public class MainClass {

    private static final String STORE_NAME = "phoenix";
    private static final String URL_CONNECTION = "localhost:5000";

    public static void main(String[] args) {

        MainClass mainClass = new MainClass() ;


//        ConnectionFactory factory = OracleConnectionFactory.getConnection(STORE_NAME, URL_CONNECTION);
//        Operator operator = factory.getOperator();
//        operator.save("/mah454", "{\"name\":\"Ali\"}");
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

//        SortedMap<Key,ValueVersion> sortedMap = operator.selectAll("/mah454/-/persons");
//        Set<Map.Entry<Key,ValueVersion>> entries = sortedMap.entrySet();
//        entries.forEach(e-> {
//            System.out.println(e.getKey().getFullPath());
//            System.out.println(new String(e.getValue().getValue().getValue()));
//        });


//        SortedMap<Key,ValueVersion> sortedMap = operator.selectByRange("/mah454/-/persons","3","6");
//        Set<Map.Entry<Key,ValueVersion>> entries = sortedMap.entrySet();
//        entries.forEach(e-> {
//            System.out.println(e.getKey().getFullPath());
//            System.out.println(new String(e.getValue().getValue().getValue()));
//        });

    }
}
