package ir.moke.phoenix;

import ir.moke.phoenix.da.Operator;
import ir.moke.phoenix.factory.ConnectionFactory;
import ir.moke.phoenix.factory.OracleConnectionFactory;
import oracle.kv.Key;
import oracle.kv.ValueVersion;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class MainClass {

    private static final String STORE_NAME = "phoenix";
    private static final String URL_CONNECTION = "localhost:5000";

    public static void main(String[] args) {

        MainClass mainClass = new MainClass() ;


        long val = Long.MAX_VALUE;
        System.out.println(val + " => " + encode(val));

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


    private static final String range = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static long decode(String s) {
        final int B = range.length();
        long num = 0;
        for (char ch : s.toCharArray()) {
            num *= B;
            num += range.indexOf(ch);
        }
        return num;
    }//decode

    public static String encode(long num) {
        final int B = range.length();
        System.out.println(B);
        num = 10 ;
        System.out.println(num % B);
        System.out.println(range.charAt((int) (num % B)));
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(range.charAt((int) (num % B)));
            num /= B;
        }
        return sb.reverse().toString();
    }//encode

}
