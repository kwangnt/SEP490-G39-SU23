package com.teachsync.utils.converters;

import com.teachsync.utils.enums.MemberRole;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class MemberRoleConverter implements AttributeConverter<MemberRole, String> {
    @Override
    public String convertToDatabaseColumn(MemberRole memberRole) {
        if (memberRole == null) {
            return null; }

        return memberRole.getStringValue();
    }

    @Override
    public MemberRole convertToEntityAttribute(String memberRole) {
         if (memberRole == null) {
             return null; }

        return Stream.of(MemberRole.values())
                .filter(s -> s.getStringValue().equals(memberRole))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new); /* Should only happen if Enum was deleted */
        /* TODO: exception handler for deleted enum */
    }
}