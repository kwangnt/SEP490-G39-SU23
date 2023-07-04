package com.teachsync.utils.converters;

import com.teachsync.utils.enums.SemesterType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class SemesterTypeConverter implements AttributeConverter<SemesterType, String> {
    @Override
    public String convertToDatabaseColumn(SemesterType semesterType) {
        if (semesterType == null) {
            return null; }

        return semesterType.getStringValue();
    }

    @Override
    public SemesterType convertToEntityAttribute(String semesterType) {
         if (semesterType == null) {
             return null; }

        return Stream.of(SemesterType.values())
                .filter(s -> s.getStringValue().equals(semesterType))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new); /* Should only happen if Enum was deleted */
        /* TODO: exception handler for deleted enum */
    }
}