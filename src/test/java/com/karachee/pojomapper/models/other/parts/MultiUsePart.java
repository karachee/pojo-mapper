package com.karachee.pojomapper.models.other.parts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.karachee.pojomapper.annotations.FromListIndex;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MultiUsePart {

    @FromListIndex(index = 32)
    private String string32;

    @FromListIndex(index = 35)
    private Double souble35;

    @FromListIndex(index = 33)
    private String string323;

    @FromListIndex(index = 34)
    private Integer integer34;

    @FromListIndex(index = 36)
    private Double double36;

    @FromListIndex(index = 39)
    private Double double39;

    @FromListIndex(index = 37)
    private Double double37;

    @FromListIndex(index = 38)
    private Double double38;

    @FromListIndex(index = 40)
    private Double double40;

    @FromListIndex(index = 41)
    private Double double41;

    @FromListIndex(index = 42)
    private Double double42;

    private Information information;
    private List<Description> descriptions;

    public String getString32() {
        return string32;
    }

    public void setString32(String string32) {
        this.string32 = string32;
    }

    public Double getSouble35() {
        return souble35;
    }

    public void setSouble35(Double souble35) {
        this.souble35 = souble35;
    }

    public String getString323() {
        return string323;
    }

    public void setString323(String string323) {
        this.string323 = string323;
    }

    public Integer getInteger34() {
        return integer34;
    }

    public void setInteger34(Integer integer34) {
        this.integer34 = integer34;
    }

    public Double getDouble36() {
        return double36;
    }

    public void setDouble36(Double double36) {
        this.double36 = double36;
    }

    public Double getDouble39() {
        return double39;
    }

    public void setDouble39(Double double39) {
        this.double39 = double39;
    }

    public Double getDouble37() {
        return double37;
    }

    public void setDouble37(Double double37) {
        this.double37 = double37;
    }

    public Double getDouble38() {
        return double38;
    }

    public void setDouble38(Double double38) {
        this.double38 = double38;
    }

    public Double getDouble40() {
        return double40;
    }

    public void setDouble40(Double double40) {
        this.double40 = double40;
    }

    public Double getDouble41() {
        return double41;
    }

    public void setDouble41(Double double41) {
        this.double41 = double41;
    }

    public Double getDouble42() {
        return double42;
    }

    public void setDouble42(Double double42) {
        this.double42 = double42;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }
}
