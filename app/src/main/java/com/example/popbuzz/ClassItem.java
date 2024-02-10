package com.example.popbuzz;

import android.widget.CheckBox;

public class ClassItem {
    String studName;
    String studId;
    String studClass;

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getStudId() {
        return studId;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }

    public String getStudClass() {
        return studClass;
    }

    public void setStudClass(String studClass) {
        this.studClass = studClass;
    }

    public ClassItem(String studName, String studId, String studClass) {
        this.studName = studName;
        this.studId = studId;
        this.studClass = studClass;
    }

}
