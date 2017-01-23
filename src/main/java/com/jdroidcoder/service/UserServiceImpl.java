package com.jdroidcoder.service;

import com.jdroidcoder.persistent.entity.UserEntity;
import com.jdroidcoder.persistent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jdroidcoder on 23.01.17.
 */
@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Iterable<UserEntity> getAllUser() {
        return userRepository.findAll();
    }
}
