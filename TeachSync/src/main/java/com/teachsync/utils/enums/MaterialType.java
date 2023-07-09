package com.teachsync.utils.enums;

public enum MaterialType {
    E_BOOK("E_BOOK"),
    PDF("PDF"),
    WORD("WORD"),
    EXCEL("EXCEL"),
    POWER_POINT("POWER_POINT");

    private final String stringValue;

    MaterialType(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
