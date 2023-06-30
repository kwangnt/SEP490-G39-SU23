package com.teachsync.utils.enums;

public enum QuestionType {
    SINGLE("SINGLE"),
    MULTIPLE("MULTIPLE"),
    ESSAY("ESSAY"),
    TEXT("TEXT");

    private final String stringValue;

    QuestionType(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
