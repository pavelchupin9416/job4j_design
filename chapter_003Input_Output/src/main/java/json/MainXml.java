package json;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class MainXml {
    public static void main(String[] args) throws Exception {
         Monitor monitor = new Monitor(false, 27, "VG279Q", new Producer("ASUS"),
                new String[]{"1920x1080", "144Гц"});
        /* Получаем контекст для доступа к АПИ */
        JAXBContext context = JAXBContext.newInstance(Monitor.class);
        /* Создаем сериализатор */
        Marshaller marshaller = context.createMarshaller();
        /* Указываем, что нам нужно форматирование */
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            /* Сериализуем */
            marshaller.marshal(monitor, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        /* Для десериализации нам нужно создать десериализатор */
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            /* десериализуем */
            Monitor result = (Monitor) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }

    }
}