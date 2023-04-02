package org.example.model.screenDom;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ButtonDom {
    private Map<String, String> attributes = new HashMap<>();
    private String t;
    private List<DDom> dDomList = new ArrayList<>();
}
