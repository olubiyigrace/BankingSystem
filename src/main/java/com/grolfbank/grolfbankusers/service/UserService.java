package com.grolfbank.grolfbankusers.service;

import com.grolfbank.grolfbankusers.dto.UserRequestDto;
import com.grolfbank.grolfbankusers.dto.UserResponseDto;
import java.util.List;

public interface UserService {
    void createUser(UserRequestDto userRequestDto);
    List<UserResponseDto> getAllUsers();
    UserResponseDto getSingleUser(Long id);
    void updateUser(Long id, UserRequestDto userRequestDto);
    void deleteUser(Long id);
}
