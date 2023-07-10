package com.teachsync.utils.converters;

import com.teachsync.utils.enums.RequestType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class RequestTypeConverter implements AttributeConverter<RequestType, String> {
    @Override
    public String convertToDatabaseColumn(RequestType requestType) {
        if (requestType == null) {
            return null; }

        return requestType.getStringValue();
    }

    @Override
    public RequestType convertToEntityAttribute(String requestType) {
         if (requestType == null) {
             return null; }

        return Stream.of(RequestType.values())
                .filter(s -> s.getStringValue().equals(requestType))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new); /* Should only happen if Enum was deleted */
        /* TODO: exception handler for deleted enum */
    }
}