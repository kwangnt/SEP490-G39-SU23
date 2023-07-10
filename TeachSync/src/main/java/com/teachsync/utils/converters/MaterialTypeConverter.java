package com.teachsync.utils.converters;

import com.teachsync.utils.enums.MaterialType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class MaterialTypeConverter implements AttributeConverter<MaterialType, String> {
    @Override
    public String convertToDatabaseColumn(MaterialType materialType) {
        if (materialType == null) {
            return null; }

        return materialType.getStringValue();
    }

    @Override
    public MaterialType convertToEntityAttribute(String materialType) {
         if (materialType == null) {
             return null; }

        return Stream.of(MaterialType.values())
                .filter(s -> s.getStringValue().equals(materialType))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new); /* Should only happen if Enum was deleted */
        /* TODO: exception handler for deleted enum */
    }
}