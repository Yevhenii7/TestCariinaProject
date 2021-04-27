package com.qaprosoft.carina.demo.gui.components.compare;

import java.util.HashMap;
import java.util.Map;

public class ModelSpecss {

    public enum SpecType {
        TECHNOLOGY("Technology"),
        ANNOUNCED("Announced");

        private String type;

        SpecType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    private Map<SpecType, String> modelSpecsMap;

    public ModelSpecss() {
        this.modelSpecsMap = new HashMap<>();
    }

    public void setToModelSpecsMap(SpecType type, String spec) {
        this.modelSpecsMap.put(type, spec);
    }

    public String readSpec(SpecType type) {
        return modelSpecsMap.get(type);
    }


}
