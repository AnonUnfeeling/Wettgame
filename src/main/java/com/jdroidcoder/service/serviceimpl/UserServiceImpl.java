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
    public void createTestUser() {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setEmail("Email1");
//        userEntity.setUsername("username1");
//        userEntity.setActivationCode("act-code");
//        userEntity.setPassword("password");
//        userEntity.setActive(1);
//        userEntity.setBlocked(0);
//        UserDataEntity userDataEntity = new UserDataEntity();
//        userDataEntity.setAboutMe("about me1");
//        userDataEntity.setLanguageEntity(new LanguageEntity("ENG1"));
//        userDataEntity.setBirthday(LocalDate.now());
//        userDataEntity.setFirstName("firstName1");
//        userDataEntity.setLastName("lastName1");
//        userDataEntity.setLuckyNumber(123);
//        userDataEntity.setMobile("mobile1");
//        userDataEntity.setPhone("phone1");
//        userDataEntity.setSalutationEntity(new SalutationEntity("Salutation1"));
//        userDataEntity.setSexEntity(new SexEntity("sex1"));
//        userEntity.setUserData(userDataEntity);
//
//        userRepository.save(userEntity);
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
