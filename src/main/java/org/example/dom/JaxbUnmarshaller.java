package org.example.dom;

import org.example.model.screenJaxb.Screen;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.stream.Collectors;

public class JaxbUnmarshaller {

    public Screen unmarshalScreenJaxb(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String body = reader.lines().collect(Collectors.joining());
            StringReader stringReader = new StringReader(body);
            JAXBContext jaxbContext = JAXBContext.newInstance(Screen.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Screen) unmarshaller.unmarshal(stringReader);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
