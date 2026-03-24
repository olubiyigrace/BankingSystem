package com.grolfbank.users.service;

import com.grolfbank.nextofkin.dto.NextOfKinRequestDto;
import com.grolfbank.nextofkin.entity.NextOfKin;
import com.grolfbank.nextofkin.repository.NextOfKinRepository;
import com.grolfbank.users.entity.User;
import com.grolfbank.users.exception.ConflictException;
import com.grolfbank.users.exception.EntityNotFoundException;
import com.grolfbank.users.mapper.UserMapper;
import com.grolfbank.users.repository.UserRepository;
import com.grolfbank.users.dto.UserRequestDto;
import com.grolfbank.users.dto.UserResponseDto;
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

                  NextOfKinRequestDto nextOfKinRequestDto = userRequestDto.getNextOfKinRequestDto();
                   NextOfKin newKin = NextOfKin.builder()
                           .fullName(nextOfKinRequestDto.getFullName())
                           .relationship(nextOfKinRequestDto.getRelationship())
                           .address(nextOfKinRequestDto.getAddress())
                           .occupation(nextOfKinRequestDto.getOccupation())
                           .build();

                    newKin.setUser(newUser);
                    newUser.setNextOfKin(newKin);
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
