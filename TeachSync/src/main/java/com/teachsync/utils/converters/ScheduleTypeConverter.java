package com.teachsync.utils.converters;

import com.teachsync.utils.enums.ScheduleType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class ScheduleTypeConverter implements AttributeConverter<ScheduleType, String> {
    @Override
    public String convertToDatabaseColumn(ScheduleType scheduleType) {
        if (scheduleType == null) {
            return null; }

        return scheduleType.getStringValue();
    }

    @Override
    public ScheduleType convertToEntityAttribute(String scheduleType) {
         if (scheduleType == null) {
             return null; }

        return Stream.of(ScheduleType.values())
                .filter(s -> s.getStringValue().equals(scheduleType))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new); /* Should only happen if Enum was deleted */
        /* TODO: exception handler for deleted enum */
    }
}