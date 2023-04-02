package org.example.dom;

import org.example.model.screenDom.AttributeDom;
import org.example.model.screenDom.ButtonDom;
import org.example.model.screenDom.DDom;
import org.example.model.screenDom.ScreenDom;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomUnmarshaller {

    public ScreenDom unmarshalScreenDom(String filename) {
        try {
            ScreenDom screenDom = new ScreenDom();

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(filename);
            Node root = document.getFirstChild();

            NamedNodeMap attributes = root.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                screenDom.getAttributes().put(attributes.item(i).getNodeName(), attributes.item(i).getNodeValue());
            }

            NodeList childNode = root.getChildNodes();

            for (int i = 0; i < childNode.getLength(); i++) {
                Node element = childNode.item(i);
                if (element.getNodeName().equals("Title")) {
                    screenDom.setTitle(element.getTextContent());
                }
                if (element.getNodeName().equals("Description")) {
                    screenDom.setDescription(element.getTextContent());
                }
            }

            screenDom.setButtons(unmarshalButtonsDom(document));
            screenDom.setAttributeDomList(unmarshalAttributesDom(document));

            return screenDom;

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<AttributeDom> unmarshalAttributesDom(Document document) {
        NodeList rootList = document.getDocumentElement().getElementsByTagName("Attribute");
        NamedNodeMap attributes;
        NodeList childNode;
        List<AttributeDom> attributeDomList = new ArrayList<>();

        for (int i = 0; i < rootList.getLength(); i++) {
            AttributeDom attributeDom = new AttributeDom();
            attributes = rootList.item(i).getAttributes();

            for (int j = 0; j < attributes.getLength(); j++) {
                attributeDom.getAttributes().put(attributes.item(j).getNodeName(), attributes.item(j).getTextContent());
            }

            childNode = rootList.item(i).getChildNodes();

            for (int j = 0; j < childNode.getLength(); j++) {
                Node element = childNode.item(j);
                if (element.getNodeName().equals("V")) {
                    attributeDom.setV(element.getTextContent());
                }
            }

            attributeDomList.add(attributeDom);
        }
        return attributeDomList;
    }

    private List<ButtonDom> unmarshalButtonsDom(Document document) {
        NodeList rootList = document.getDocumentElement().getElementsByTagName("Button");
        NamedNodeMap attributes;
        NodeList childNode;
        List<ButtonDom> buttons = new ArrayList<>();
        for (int i = 0; i < rootList.getLength(); i++) {

            attributes = rootList.item(i).getAttributes();
            ButtonDom button = new ButtonDom();

            for (int j = 0; j < attributes.getLength(); j++) {

                button.getAttributes().put(attributes.item(j).getNodeName(), attributes.item(j).getTextContent());
                buttons.add(button);
            }

            childNode = rootList.item(i).getChildNodes();

            for (int j = 0; j < childNode.getLength(); j++) {
                Node element = childNode.item(j);
                NamedNodeMap attr = element.getAttributes();

                if (element.getNodeName().equals("T")) {
                    button.setT(element.getTextContent());
                }
                if (element.getNodeName().equals("D")) {
                    DDom dDom = new DDom();
                    dDom.setD(element.getTextContent());
                    if (attr.getLength() != 0) {
                        for (int k = 0; k < attr.getLength(); k++) {
                            dDom.getAttributes().put(attr.item(k).getNodeName(), attr.item(k).getNodeValue());
                        }
                    }

                    button.getDDomList().add(dDom);
                }
            }
        }
        return buttons;
    }
}
