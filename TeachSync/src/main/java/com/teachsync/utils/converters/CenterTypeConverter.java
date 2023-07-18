package com.teachsync.utils.converters;

import com.teachsync.utils.enums.CenterType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class CenterTypeConverter implements AttributeConverter<CenterType, String> {
    @Override
    public String convertToDatabaseColumn(CenterType centerType) {
        if (centerType == null) {
            return null; }

        return centerType.getStringValue();
    }

    @Override
    public CenterType convertToEntityAttribute(String centerType) {
         if (centerType == null) {
             return null; }

        return Stream.of(CenterType.values())
                .filter(s -> s.getStringValue().equals(centerType))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new); /* Should only happen if Enum was deleted */
        /* TODO: exception handler for deleted enum */
    }
}