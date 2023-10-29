package com.wanted.sns.dto;

import com.wanted.sns.domain.*;
import com.wanted.sns.support.*;
import java.time.*;

public record SignUpRequest(
        String memberId,
        String email,
        String password,
        LocalDate dateOfBirth,
        String name,
        String phoneNumber
) {
    public Member toEntity(final String encryptedPassword) {
        return Member.builder()
                .memberId(memberId)
                .email(new Email(email))
                .password(encryptedPassword)
                .dateOfBirth(dateOfBirth)
                .name(name)
                .phoneNumber(phoneNumber)
                .role(MemberRole.GUEST)
                .build();
    }
}
