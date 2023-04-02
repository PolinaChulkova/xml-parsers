package org.example.model.screenDom;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class DDom {
    private Map<String, String> attributes = new HashMap<>();
    private String d;

    public DDom withD(String value) {
        this.d = value;
        return this;
    }
}
