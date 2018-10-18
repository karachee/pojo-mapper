package com.karachee.pojomapper.models.other.parts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.karachee.pojomapper.annotations.FromListIndex;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Description {

    @FromListIndex(index = 14, parent = "MainPart.Information")
    @FromListIndex(index = 45, parent = "MultiUsePart.Information")
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}