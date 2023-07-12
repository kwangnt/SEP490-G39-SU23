package com.teachsync.utils.enums;

public enum ApplicationDetailType {
    CV("CV"),
    CITIZEN_ID("CITIZEN_ID"),
    LICENSE("LICENSE");

    private final String stringValue;

    ApplicationDetailType(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
