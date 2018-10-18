package com.karachee.pojomapper.models.other.parts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.karachee.pojomapper.annotations.FromListIndex;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Code {

    @FromListIndex(index = 11, parent = "MainPart.Information")
    @FromListIndex(index = 43, parent = "MultiUsePart.Information")
    private String code1;

    @FromListIndex(index = 13, parent = "MainPart.Information")
    @FromListIndex(index = 44, parent = "MultiUsePart.Information")
    private String code2;

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }
}
