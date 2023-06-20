package com.teachsync.utils.converters;

import com.teachsync.utils.enums.QuestionType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class QuestionTypeConverter implements AttributeConverter<QuestionType, String> {
    @Override
    public String convertToDatabaseColumn(QuestionType questionType) {
        if (questionType == null) {
            return null; }

        return questionType.getStringValue();
    }

    @Override
    public QuestionType convertToEntityAttribute(String questionType) {
         if (questionType == null) {
             return null; }

        return Stream.of(QuestionType.values())
                .filter(s -> s.getStringValue().equals(questionType))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new); /* Should only happen if Enum was deleted */
        /* TODO: exception handler for deleted enum */
    }
}