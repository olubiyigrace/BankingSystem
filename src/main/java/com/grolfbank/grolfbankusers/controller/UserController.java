package com.grolfbank.grolfbankusers.controller;

import com.grolfbank.grolfbankusers.dto.UserRequestDto;
import com.grolfbank.grolfbankusers.entity.User;
import com.grolfbank.grolfbankusers.service.UserService;
import com.grolfbank.grolfbankusers.util.ResponseBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")

public class UserController {
    private final UserService userService;
    private final ResponseBuilder responseBuilder;

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody UserRequestDto userRequestDto){
        userService.createUser(userRequestDto);
        return responseBuilder.buildResponse(true, "User created successfully!", HttpStatus.CREATED, null);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getUser(){
        var user = userService.getAllUsers();
        return responseBuilder.buildResponse(true, "Users retrieved successfully!", HttpStatus.FOUND, user);
    }

    @GetMapping("/getSingle/{id}")
    public ResponseEntity<?> getSingleUser(@PathVariable Long id){
        var user = userService.getSingleUser(id);
        return responseBuilder.buildResponse(true, "User retrieved successfully!", HttpStatus.FOUND, user);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @Valid @RequestBody UserRequestDto userRequestDto){
        userService.updateUser(id, userRequestDto);
        return responseBuilder.buildResponse(true, "User updated successfully!", HttpStatus.OK, null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return responseBuilder.buildResponse(true, "User deleted successfully!", HttpStatus.OK, null);
    }
}
