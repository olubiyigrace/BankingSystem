package com.grolfbank.nextofkin.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class NextOfKinResponseDto {
    private String fullName;
    private String relationship;
    private String address;
    private String occupation;

}
