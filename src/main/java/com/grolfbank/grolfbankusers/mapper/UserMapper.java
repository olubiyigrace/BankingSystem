package com.grolfbank.grolfbankusers.mapper;

import com.grolfbank.grolfbankusers.dto.UserRequestDto;
import com.grolfbank.grolfbankusers.dto.UserResponseDto;
import com.grolfbank.grolfbankusers.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User userRequestDtoToEntity(UserRequestDto userRequestDto){
        return User.builder()
                .fullName(userRequestDto.getFullName())
                .dateOfBirth(userRequestDto.getDateOfBirth())
                .email(userRequestDto.getEmail())
                .mobile(userRequestDto.getMobile())
                .bvn(userRequestDto.getBvn())
                .nin(userRequestDto.getNin())
                .gender(userRequestDto.getGender())
                .occupation(userRequestDto.getOccupation())
                .build();
    }

    public UserResponseDto entityToUserResponseDto(User user){
        return UserResponseDto.builder()
                .fullName(user.getFullName())
                .dateOfBirth(user.getDateOfBirth())
                .gender(user.getGender())
                .email(user.getEmail())
                .mobile(user.getMobile())
                .id(user.getId())
                .bvn(user.getBvn())
                .nin(user.getNin())
                .occupation(user.getOccupation())
                .createdDate(user.getCreatedAt())
                .build();
    }
}
