package com.teachsync.utils.enums;

public enum SemesterType {
    SEASON("SEASON"),
    ADHOC("ADHOC");

    private final String stringValue;

    SemesterType(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
