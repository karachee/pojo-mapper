package com.karachee.pojomapper.models;

import com.karachee.pojomapper.annotations.FromListIndex;

public class NestedTestObj {

    @FromListIndex(index = 1)
    private String nestedVar1;

    public String getNestedVar1() {
        return nestedVar1;
    }

    public void setNestedVar1(String nestedVar1) {
        this.nestedVar1 = nestedVar1;
    }
}
