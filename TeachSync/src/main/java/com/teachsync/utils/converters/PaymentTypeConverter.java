package com.teachsync.utils.converters;

import com.teachsync.utils.enums.PaymentType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class PaymentTypeConverter implements AttributeConverter<PaymentType, String> {
    @Override
    public String convertToDatabaseColumn(PaymentType paymentType) {
        if (paymentType == null) {
            return null; }

        return paymentType.getStringValue();
    }

    @Override
    public PaymentType convertToEntityAttribute(String paymentType) {
         if (paymentType == null) {
             return null; }

        return Stream.of(PaymentType.values())
                .filter(s -> s.getStringValue().equals(paymentType))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new); /* Should only happen if Enum was deleted */
        /* TODO: exception handler for deleted enum */
    }
}