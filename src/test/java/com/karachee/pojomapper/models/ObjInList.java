package com.karachee.pojomapper.models;

import com.karachee.pojomapper.annotations.FromListIndex;

public class ObjInList {

    @FromListIndex(index = 3)
    private Integer inListValue;

    public Integer getInListValue() {
        return inListValue;
    }

    public void setInListValue(Integer inListValue) {
        this.inListValue = inListValue;
    }
}
