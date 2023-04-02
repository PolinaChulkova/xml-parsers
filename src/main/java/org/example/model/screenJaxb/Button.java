package org.example.model.screenJaxb;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Button {
    @XmlAttribute(name = "Action")
    private String action;
    @XmlAttribute(name = "Color")
    private String color;
    @XmlAttribute(name = "Condition")
    private String condition;
    @XmlElement(name = "T")
    private String t;
    @XmlElement(name = "D")
    private List<D> dList = new ArrayList<>();
}
