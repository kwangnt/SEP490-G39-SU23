package com.teachsync.utils.enums;

public enum RoomType {
    CLASSROOM("CLASSROOM"),
    LIBRARY("LIBRARY"),;

    private final String stringValue;

    RoomType(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
