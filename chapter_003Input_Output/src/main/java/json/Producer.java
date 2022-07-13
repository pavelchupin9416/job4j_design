package json;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "producer")
public class Producer {
    @XmlAttribute
    private String name;

    public Producer(){};
    public Producer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Producer{"
                + "name='" + name + '\''
                + '}';
    }
}
