package com.teachsync.utils.converters;

import com.teachsync.utils.enums.TestType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class TestTypeConverter implements AttributeConverter<TestType, String> {
    @Override
    public String convertToDatabaseColumn(TestType testType) {
        if (testType == null) {
            return null; }

        return testType.getStringValue();
    }

    @Override
    public TestType convertToEntityAttribute(String testType) {
         if (testType == null) {
             return null; }

        return Stream.of(TestType.values())
                .filter(s -> s.getStringValue().equals(testType))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new); /* Should only happen if Enum was deleted */
        /* TODO: exception handler for deleted enum */
    }
}