package com.teachsync.utils.enums;

public enum TestType {
    FIFTEEN_MINUTE("FIFTEEN_MINUTE"),
    MIDTERM("MIDTERM"),
    FINAL("FINAL");

    private final String stringValue;

    TestType(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
