package com.teachsync.utils.converters;

import com.teachsync.utils.enums.RoomType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class RoomTypeConverter implements AttributeConverter<RoomType, String> {
    @Override
    public String convertToDatabaseColumn(RoomType roomType) {
        if (roomType == null) {
            return null; }

        return roomType.getStringValue();
    }

    @Override
    public RoomType convertToEntityAttribute(String roomType) {
         if (roomType == null) {
             return null; }

        return Stream.of(RoomType.values())
                .filter(s -> s.getStringValue().equals(roomType))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new); /* Should only happen if Enum was deleted */
        /* TODO: exception handler for deleted enum */
    }
}