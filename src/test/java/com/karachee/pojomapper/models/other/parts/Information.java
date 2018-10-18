package com.karachee.pojomapper.models.other.parts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.karachee.pojomapper.annotations.FromListIndex;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Information {

    @FromListIndex(index = 24)
    private Double double24;

    @FromListIndex(index = 21)
    private Double double21;

    @FromListIndex(index = 23)
    private String string23;

    @FromListIndex(index = 19)
    private String string19;

    @FromListIndex(index = 22)
    private String string22;

    @FromListIndex(index = 25)
    private Double double25;

    @FromListIndex(index = 28)
    private Double double28;

    @FromListIndex(index = 26)
    private Double double26;

    @FromListIndex(index = 27)
    private Double double27;

    @FromListIndex(index = 29)
    private Double double29;

    @FromListIndex(index = 31)
    private Double double31;

    @FromListIndex(index = 30)
    private Double double30;

    private List<String> notes;
    private List<Description> descriptions;
    private List<Code> codes;

    public Double getDouble24() {
        return double24;
    }

    public void setDouble24(Double double24) {
        this.double24 = double24;
    }

    public Double getDouble21() {
        return double21;
    }

    public void setDouble21(Double double21) {
        this.double21 = double21;
    }

    public String getString23() {
        return string23;
    }

    public void setString23(String string23) {
        this.string23 = string23;
    }

    public String getString19() {
        return string19;
    }

    public void setString19(String string19) {
        this.string19 = string19;
    }

    public String getString22() {
        return string22;
    }

    public void setString22(String string22) {
        this.string22 = string22;
    }

    public Double getDouble25() {
        return double25;
    }

    public void setDouble25(Double double25) {
        this.double25 = double25;
    }

    public Double getDouble28() {
        return double28;
    }

    public void setDouble28(Double double28) {
        this.double28 = double28;
    }

    public Double getDouble26() {
        return double26;
    }

    public void setDouble26(Double double26) {
        this.double26 = double26;
    }

    public Double getDouble27() {
        return double27;
    }

    public void setDouble27(Double double27) {
        this.double27 = double27;
    }

    public Double getDouble29() {
        return double29;
    }

    public void setDouble29(Double double29) {
        this.double29 = double29;
    }

    public Double getDouble31() {
        return double31;
    }

    public void setDouble31(Double double31) {
        this.double31 = double31;
    }

    public Double getDouble30() {
        return double30;
    }

    public void setDouble30(Double double30) {
        this.double30 = double30;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

    public List<Code> getCodes() {
        return codes;
    }

    public void setCodes(List<Code> codes) {
        this.codes = codes;
    }
}
