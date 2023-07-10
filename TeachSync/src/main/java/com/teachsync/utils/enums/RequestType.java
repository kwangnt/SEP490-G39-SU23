package com.teachsync.utils.enums;

public enum RequestType {
    ENROLL("ENROLL"),
    CHANGE_CLASS("CHANGE_CLASS"),
    APPLICATION("APPLICATION");

    private final String stringValue;

    RequestType(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
