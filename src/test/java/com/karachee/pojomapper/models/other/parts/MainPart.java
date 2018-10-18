package com.karachee.pojomapper.models.other.parts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.karachee.pojomapper.annotations.FromListIndex;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MainPart {

    @FromListIndex(index = 6)
    private String string6;

    @FromListIndex(index = 7)
    private String string7;

    @FromListIndex(index = 18)
    private String string18;

    @FromListIndex(index = 16)
    private String string16;

    @FromListIndex(index = 17)
    private String string17;

    @FromListIndex(index = 10)
    private String string10;

    private List<MultiUsePart> multiUseParts;

    private Information information;

    public void addMultiUsePart(MultiUsePart multiUsePart){
        if(this.multiUseParts==null){
            this.multiUseParts =  new ArrayList<>();
        }

        this.multiUseParts.add(multiUsePart);
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

    public String getString18() {
        return string18;
    }

    public void setString18(String string18) {
        this.string18 = string18;
    }

    public String getString16() {
        return string16;
    }

    public void setString16(String string16) {
        this.string16 = string16;
    }

    public String getString17() {
        return string17;
    }

    public void setString17(String string17) {
        this.string17 = string17;
    }

    public String getString10() {
        return string10;
    }

    public void setString10(String string10) {
        this.string10 = string10;
    }

    public List<MultiUsePart> getMultiUseParts() {
        return multiUseParts;
    }

    public void setMultiUseParts(List<MultiUsePart> multiUseParts) {
        this.multiUseParts = multiUseParts;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }
}