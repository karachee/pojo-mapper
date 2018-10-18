package com.karachee.pojomapper.models.other;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.karachee.pojomapper.annotations.FromListIndex;
import com.karachee.pojomapper.models.other.parts.MainPart;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Other {

    @FromListIndex(index = 0)
    private String string0;

    @FromListIndex(index = 1)
    private String string1;

    @FromListIndex(index = 2)
    private String string2;

    @FromListIndex(index = 3)
    private String string3;

    @FromListIndex(index = 4)
    private String string4;

    @FromListIndex(index = 5)
    private String string5;

    @FromListIndex(index = 6)
    private String string6;

    @FromListIndex(index = 7)
    private String string7;

    @FromListIndex(index = 8)
    private String string9;

    private MainPart mainPart;

    public String getString0() {
        return string0;
    }

    public void setString0(String string0) {
        this.string0 = string0;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    public String getString3() {
        return string3;
    }

    public void setString3(String string3) {
        this.string3 = string3;
    }

    public String getString4() {
        return string4;
    }

    public void setString4(String string4) {
        this.string4 = string4;
    }

    public String getString5() {
        return string5;
    }

    public void setString5(String string5) {
        this.string5 = string5;
    }

    public String getString6() {
        return string6;
    }

    public void setString6(String string6) {
        this.string6 = string6;
    }

    public String getString7() {
        return string7;
    }

    public void setString7(String string7) {
        this.string7 = string7;
    }

    public String getString9() {
        return string9;
    }

    public void setString9(String string9) {
        this.string9 = string9;
    }

    public MainPart getMainPart() {
        return mainPart;
    }

    public void setMainPart(MainPart mainPart) {
        this.mainPart = mainPart;
    }
}
