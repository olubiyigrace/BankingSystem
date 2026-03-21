package com.grolfbank.grolfbankusers.service;

import com.grolfbank.grolfbankusers.entity.User;
import com.grolfbank.grolfbankusers.exception.ConflictException;
import com.grolfbank.grolfbankusers.exception.CustomBadRequest;
import com.grolfbank.grolfbankusers.exception.EntityNotFoundException;
import com.grolfbank.grolfbankusers.mapper.UserMapper;
import com.grolfbank.grolfbankusers.repository.UserRepository;
import com.grolfbank.grolfbankusers.dto.UserRequestDto;
import com.grolfbank.grolfbankusers.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void createUser(UserRequestDto userRequestDto) {
        Optional<User> findUser = userRepository.findByEmail(userRequestDto.getEmail());
        if (findUser.isPresent()) throw new ConflictException("User with the email " + userRequestDto.getEmail() + " already exists.");

            User newUser = userMapper.userRequestDtoToEntity(userRequestDto);
                   newUser.setCreatedAt(LocalDateTime.now());
                    userRepository.save(newUser);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> userMapper.entityToUserResponseDto(user)).toList();
    }

    @Override
    public UserResponseDto getSingleUser(Long id) {
        Optional<User> findUser = userRepository.findById(id);
        if (findUser.isEmpty()) throw new EntityNotFoundException("User with the id " + id + " does not exist.");

        User foundUser = findUser.get();
        return userMapper.entityToUserResponseDto(foundUser);
    }

    @Override
    public void updateUser(Long id, UserRequestDto userRequestDto) {
        Optional<User> findUser = userRepository.findById(id);
        if (findUser.isEmpty()) throw new EntityNotFoundException("User with the id " + id + " does not exist.");

       User foundUser = findUser.get();
       foundUser.setUpdatedAt(LocalDateTime.now());
             userRepository.save(foundUser);
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> findUser = userRepository.findById(id);
        if(findUser.isEmpty()) throw new EntityNotFoundException("User with the id " + id + " does not exist.");

        User foundUser = findUser.get();
        userRepository.delete(foundUser);
    }
}
