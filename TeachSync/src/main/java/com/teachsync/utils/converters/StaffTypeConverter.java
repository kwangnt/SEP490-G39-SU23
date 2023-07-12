package com.teachsync.utils.converters;

import com.teachsync.utils.enums.StaffType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class StaffTypeConverter implements AttributeConverter<StaffType, String> {
    @Override
    public String convertToDatabaseColumn(StaffType staffType) {
        if (staffType == null) {
            return null; }

        return staffType.getStringValue();
    }

    @Override
    public StaffType convertToEntityAttribute(String staffType) {
         if (staffType == null) {
             return null; }

        return Stream.of(StaffType.values())
                .filter(s -> s.getStringValue().equals(staffType))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new); /* Should only happen if Enum was deleted */
        /* TODO: exception handler for deleted enum */
    }
}