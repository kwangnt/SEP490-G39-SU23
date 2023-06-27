package com.teachsync.utils.enums;

public enum MemberRole {
    TEACHER("TEACHER"),
    STUDENT("STUDENT");

    private final String stringValue;

    MemberRole(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
