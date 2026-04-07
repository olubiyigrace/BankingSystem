package com.grolfbank.users.mapper;

import com.grolfbank.nextofkin.dto.NextOfKinResponseDto;
import com.grolfbank.users.dto.UserRequestDto;
import com.grolfbank.users.dto.UserResponseDto;
import com.grolfbank.users.entity.User;
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
                .nextOfKinResponseDto(
                        NextOfKinResponseDto.builder()
                                .fullName(user.getNextOfKin().getFullName())
                                .relationship(user.getNextOfKin().getRelationship())
                                .address(user.getNextOfKin().getAddress())
                                .occupation(user.getNextOfKin().getOccupation())
                                .build()
                )
                .build();
    }
}
