package org.example.model.screenJaxb;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Attribute {
    @XmlAttribute(name = "A")
    private String a;
    @XmlElement(name = "V")
    private String v;
}
