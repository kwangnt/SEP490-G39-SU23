package com.teachsync.utils.enums;

public enum TestType {
    /* Trắc nghiệm */
    QUIZ("QUIZ"),
    /* Viết */
    ESSAY("ESSAY");

    private final String stringValue;

    TestType(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
