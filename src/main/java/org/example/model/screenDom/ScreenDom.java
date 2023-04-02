package org.example.model.screenDom;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ScreenDom {
    private Map<String, String> attributes = new HashMap<>();
    private String title;
    private String description;
    private List<ButtonDom> buttons = new ArrayList<>();
    private List<AttributeDom> attributeDomList = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<attributes= {");
        for (String key : this.attributes.keySet()) {
            sb.append(key + " = " + attributes.get(key));
        }
        sb.append("}> \n");
        sb.append("    <Title>");
        sb.append((this.title == null) ? "null" : this.title);
        sb.append("</Title> \n");
        sb.append("    <Description>");
        sb.append((this.description == null) ? "null" : this.description);
        sb.append("</Description> \n");
        sb.append("    <Buttons> \n");
        for(ButtonDom button : buttons) {
            sb.append(button);
        }
        sb.append("    </Buttons> \n");
        sb.append("    <Attributes> \n");
        for(AttributeDom attribute : attributeDomList) {
            sb.append(attribute);
        }
        sb.append("    </Attributes> \n");
        sb.append("</Screen");
        return sb.toString();
    }
}
