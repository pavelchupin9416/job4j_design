package json;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;
@XmlRootElement(name = "monitor")
@XmlAccessorType(XmlAccessType.FIELD)
public class Monitor
{
    @XmlAttribute
    private boolean curved_screen;
    @XmlAttribute
    private int diagonal;
    @XmlAttribute
    private String name_model;
    private Producer producer;
    @XmlElementWrapper(name = "characteristicses")
    @XmlElement(name = "characteristics")
    private String[] characteristics;

    public Monitor() { }

    public Monitor(boolean curved_screen, int diagonal, String name_model,Producer producer, String[] characteristics) {
        this.curved_screen = curved_screen;
        this.diagonal = diagonal;
        this.name_model = name_model;
        this.producer = producer;
        this.characteristics = characteristics;
    }

    public boolean isCurved_screen() {
        return curved_screen;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public String getName_model() {
        return name_model;
    }

    public Producer getProducer() {
        return producer;
    }

    public String[] getCharacteristics() {
        return characteristics;
    }

    @Override
    public String toString() {
        return "Monitor{"
                + "name_model=" + name_model
                + ", curved_screen=" + curved_screen
                + ", diagonal=" + diagonal
                + ", producer=" + producer
                + ", characteristics=" + Arrays.toString(characteristics)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {

        final  Monitor monitor = new Monitor(false,27, "VG279Q", new Producer("ASUS"),
                new String[]{"1920x1080","144Гц"});


        JAXBContext context = JAXBContext.newInstance(Monitor.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(monitor, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
