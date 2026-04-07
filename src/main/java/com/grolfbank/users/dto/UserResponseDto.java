package com.grolfbank.users.dto;

import com.grolfbank.nextofkin.dto.NextOfKinResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UserResponseDto {
    private Long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private String gender;
    private String email;
    private String mobile;
    private String bvn;
    private String nin;
    private String occupation;
    private LocalDateTime createdDate;
    private NextOfKinResponseDto nextOfKinResponseDto;
}
