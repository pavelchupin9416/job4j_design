package json;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;
@XmlRootElement(name = "monitor")
@XmlAccessorType(XmlAccessType.FIELD)
public class Monitor {
    @XmlAttribute
    private boolean curvedScreen;
    @XmlAttribute
    private int diagonal;
    @XmlAttribute
    private String nameModel;
    private Producer producer;
    @XmlElementWrapper(name = "characteristicses")
    @XmlElement(name = "characteristics")
    private String[] characteristics;

    public Monitor() { }

    public Monitor(boolean curvedScreen, int diagonal, String nameModel, Producer producer, String[] characteristics) {
        this.curvedScreen = curvedScreen;
        this.diagonal = diagonal;
        this.nameModel = nameModel;
        this.producer = producer;
        this.characteristics = characteristics;
    }

    public boolean isCurvedScreen() {
        return curvedScreen;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public String getNameModel() {
        return nameModel;
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
                + "name_model=" + nameModel
                + ", curved_screen=" + curvedScreen
                + ", diagonal=" + diagonal
                + ", producer=" + producer
                + ", characteristics=" + Arrays.toString(characteristics)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {

        final  Monitor monitor = new Monitor(false, 27, "VG279Q", new Producer("ASUS"),
                new String[]{"1920x1080", "144Гц"});


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
