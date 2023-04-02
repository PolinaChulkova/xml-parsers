package org.example;

import org.example.dom.JaxbMarshaller;
import org.example.dom.JaxbUnmarshaller;
import org.example.model.screenJaxb.Screen;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, SAXException {
//        DomUnmarshaller unmarshaller = new DomUnmarshaller();
//        ScreenDom screenDom = unmarshaller.unmarshalScreenDom("body.xml");
//        System.out.println(screenDom.toString());
        JaxbUnmarshaller unmarshaller = new JaxbUnmarshaller();
        Screen screen = unmarshaller.unmarshalScreenJaxb("body.xml");
        JaxbMarshaller marshaller = new JaxbMarshaller();
        System.out.println(marshaller.marshallerJaxb(screen));
    }
}