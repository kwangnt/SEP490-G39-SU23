package com.teachsync.utils.enums;

public enum CenterType {
    ENGLISH("ENGLISH");

    private final String stringValue;

    CenterType(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
