package com.jdroidcoder.controller;

import com.jdroidcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jdroidcoder on 23.01.17.
 */
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUsers")
    public ResponseEntity getUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/createTestUser")
    public ResponseEntity createTestUser() {
        userService.createTestUser();
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
