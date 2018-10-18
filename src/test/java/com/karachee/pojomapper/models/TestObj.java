package com.karachee.pojomapper.models;

import com.karachee.pojomapper.annotations.FromListIndex;
import com.karachee.pojomapper.annotations.FromMapKey;

import java.time.LocalDate;
import java.util.List;

public class TestObj {

    @FromMapKey(stringKey = "testKey")
    private String mapValue;

    @FromListIndex(indices = {4, 5})
    private List<String> notes;

    @FromListIndex(index = 0)
    private String var1;

    @FromListIndex(index = 2)
    private LocalDate localDate;

    private List<ObjInList> objList;

    private NestedTestObj nestedTestObj;

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public NestedTestObj getNestedTestObj() {
        return nestedTestObj;
    }

    public void setNestedTestObj(NestedTestObj nestedTestObj) {
        this.nestedTestObj = nestedTestObj;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public List<ObjInList> getObjList() {
        return objList;
    }

    public void setObjList(List<ObjInList> objList) {
        this.objList = objList;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    public String getMapValue() {
        return mapValue;
    }

    public void setMapValue(String mapValue) {
        this.mapValue = mapValue;
    }
}
