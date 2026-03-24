package com.grolfbank.nextofkin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class NextOfKinRequestDto {
    private String fullName;
    private String relationship;
    private String address;
    private String occupation;
}
