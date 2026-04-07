package com.grolfbank.users.service;

import com.grolfbank.users.dto.UserRequestDto;
import com.grolfbank.users.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);
    List<UserResponseDto> getAllUsers();
    UserResponseDto getSingleUser(Long id);
    void updateUser(Long id, UserRequestDto userRequestDto);
    void deleteUser(Long id);
}
