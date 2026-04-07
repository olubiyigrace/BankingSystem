package com.grolfbank.users.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grolfbank.nextofkin.dto.NextOfKinRequestDto;
import com.grolfbank.nextofkin.entity.NextOfKin;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserRequestDto {

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Full name is required")
    @Pattern(regexp = "^[A-Za-z]+\\s[A-Za-z]+\\s[A-Za-z]+$",
            message = "Please enter first, middle, and last name separated by spaces")
    @Column(updatable = false)
    private String fullName;

    @NotNull(message = "Date of Birth cannot be null")
    @Past(message = "Date of Birth must be in the past")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(updatable = false)
    private LocalDate dateOfBirth;

    @NotNull(message = "Gender cannot be null")
    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "^(?i)(Male|Female)$", message = "Gender must be either 'male' or 'female'")
    @Column(updatable = false)
    private String gender;

    @NotNull(message = "Password cannot be null")
    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*+=])(?=\\S+$).{8,}$",
            message = "Password must contain at least one uppercase, one lowercase, one digit, a character and no whitespace")
    private String password;

    @NotNull(message = "Mobile number cannot be null")
    @NotBlank(message = "Mobile number is required")
    @Size(min = 11, max = 14, message = "Mobile number must be 14 characters ")
    @Pattern(regexp = "^\\+?[1-9][0-9]{11,14}$",
            message = "Invalid mobile number format")
    @Column(updatable = false)
    private String mobile;

    @NotNull(message = "BVN cannot be null")
    @NotBlank(message = "BVN is required")
    @Pattern(regexp = "^[0-9]{11}$", message = "BVN must be exactly 11 digits")
    @Column(updatable = false)
    private String bvn;

    @NotNull(message = "NIN cannot be null")
    @NotBlank(message = "NIN is required")
    @Pattern(regexp = "^[0-9]{11}$", message = "NIN must be exactly 11 digits")
    @Column(updatable = false)
    private String nin;

    @NotNull(message = "Email cannot be null")
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email input")
    @Column(updatable = false)
    private String email;

    @NotNull(message = "Occupation cannot be null")
    @NotBlank(message = "Occupation is required")
    @Column(updatable = false)
    private String occupation;

    @NotNull(message = "Next of Kin cannot be null")
    @NotBlank(message = "Next of Kin is required")
    @Column(updatable = false)
    private NextOfKinRequestDto nextOfKinRequestDto;
}
