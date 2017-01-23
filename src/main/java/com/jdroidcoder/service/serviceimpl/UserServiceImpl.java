package com.jdroidcoder.service.serviceimpl;

import com.jdroidcoder.persistent.dto.UserDto;
import com.jdroidcoder.persistent.entity.*;
import com.jdroidcoder.persistent.repository.UserRepository;
import com.jdroidcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jdroidcoder on 23.01.17.
 */
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Iterable<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserByName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void createUser(UserDto userDto) {
        userRepository.save(convertDtoToEntity(userDto));
    }

    @Override
    public void removeByID(Long id) {
        userRepository.delete(id);
    }

    private UserEntity convertDtoToEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDto.getEmail());
        userEntity.setUsername(userDto.getUsername());
        userEntity.setActivationCode(userDto.getActivationCode());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setActive(userDto.getActive());
        userEntity.setBlocked(userDto.getBlocked());
        userEntity.setUserData(userDto.getUserDataEntity());
        return userEntity;
    }
}
