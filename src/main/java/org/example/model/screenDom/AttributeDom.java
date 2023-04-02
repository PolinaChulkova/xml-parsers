package org.example.model.screenDom;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class AttributeDom {
    private Map<String, String> attributes = new HashMap<>();
    private String v;
}
