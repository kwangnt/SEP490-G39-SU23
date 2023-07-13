package com.teachsync.utils.enums;

public enum PaymentType {
    CASH("CASH"),
    TRANSFER("TRANSFER");

    private final String stringValue;

    PaymentType(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
