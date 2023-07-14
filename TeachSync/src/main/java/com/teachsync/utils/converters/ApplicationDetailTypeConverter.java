package com.teachsync.utils.converters;

import com.teachsync.utils.enums.ApplicationDetailType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class ApplicationDetailTypeConverter implements AttributeConverter<ApplicationDetailType, String> {
    @Override
    public String convertToDatabaseColumn(ApplicationDetailType applicationDetailType) {
        if (applicationDetailType == null) {
            return null; }

        return applicationDetailType.getStringValue();
    }

    @Override
    public ApplicationDetailType convertToEntityAttribute(String applicationDetailType) {
         if (applicationDetailType == null) {
             return null; }

        return Stream.of(ApplicationDetailType.values())
                .filter(s -> s.getStringValue().equals(applicationDetailType))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new); /* Should only happen if Enum was deleted */
        /* TODO: exception handler for deleted enum */
    }
}