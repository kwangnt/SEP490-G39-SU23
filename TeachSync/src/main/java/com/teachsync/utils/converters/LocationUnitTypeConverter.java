package com.teachsync.utils.converters;

import com.teachsync.utils.enums.LocationUnitType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class LocationUnitTypeConverter implements AttributeConverter<LocationUnitType, String> {
    @Override
    public String convertToDatabaseColumn(LocationUnitType locationUnitType) {
        if (locationUnitType == null) {
            return null; }

        return locationUnitType.getStringValue();
    }

    @Override
    public LocationUnitType convertToEntityAttribute(String locationUnitType) {
         if (locationUnitType == null) {
             return null; }

        return Stream.of(LocationUnitType.values())
                .filter(s -> s.getStringValue().equals(locationUnitType))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new); /* Should only happen if Enum was deleted */
        /* TODO: exception handler for deleted enum */
    }
}