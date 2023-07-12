package com.teachsync.utils.enums;

public enum StaffType {
    LEADER("LEADER"),
    TEACHER("TEACHER"),
    DEAN("DEAN");

    private final String stringValue;

    StaffType(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
