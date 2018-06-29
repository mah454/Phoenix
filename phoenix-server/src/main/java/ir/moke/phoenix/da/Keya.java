package ir.moke.phoenix.da;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Keya {

    @XmlElement
    private String key ;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Keya{" +
                "key='" + key + '\'' +
                '}';
    }
}
