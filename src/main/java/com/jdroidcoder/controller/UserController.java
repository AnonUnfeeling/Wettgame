package com.jdroidcoder.controller;

import com.jdroidcoder.persistent.dto.UserDto;
import com.jdroidcoder.persistent.entity.UserEntity;
import com.jdroidcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by jdroidcoder on 23.01.17.
 */
@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/getUsers")
    public ResponseEntity<Iterable<UserEntity>> getUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping(value = "/registration")
    public ResponseEntity registrationUser(@Valid UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        userService.createUser(userDto);
        return ResponseEntity.ok("User was registered");
    }

    @PostMapping(value = "/getUser")
    public ResponseEntity getUser(@RequestParam String username) {
        return ResponseEntity.ok(userService.getUserByName(username));
    }

    @GetMapping(value = "/createTest")
    public void createTest() {
        userService.createTestUser();
    }
}
