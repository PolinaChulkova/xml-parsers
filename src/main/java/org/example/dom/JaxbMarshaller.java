package org.example.dom;

import org.example.model.screenJaxb.Screen;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class JaxbMarshaller {
    public StringWriter marshallerJaxb(Screen screen) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Screen.class);

            StringWriter stringWriter = new StringWriter();
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            screen.setTitle("Изменили заглавие");
            screen.getButtons().get(0).getDList().get(0).setColor("black");
            screen.getButtons().get(0).getDList().get(0).setD("Цвет кнопки черный");
            marshaller.marshal(screen, stringWriter);
            return stringWriter;

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
