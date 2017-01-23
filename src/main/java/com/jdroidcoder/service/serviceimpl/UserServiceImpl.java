package com.jdroidcoder.service.serviceimpl;

import com.jdroidcoder.persistent.entity.*;
import com.jdroidcoder.persistent.repository.UserRepository;
import com.jdroidcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("Email1");
        userEntity.setUsername("username");
        userEntity.setActivationCode("act-code");
        userEntity.setPassword("password");
        userEntity.setActive(1);
        userEntity.setBlocked(0);

        UserDataEntity userDataEntity = new UserDataEntity();
        userDataEntity.setAboutMe("about me");
        userDataEntity.setLanguageEntity(new LanguageEntity("ENG"));
        userDataEntity.setBirthday(LocalDate.now());
        userDataEntity.setFirstName("firstName");
        userDataEntity.setLastName("lastName");
        userDataEntity.setLuckyNumber(123);
        userDataEntity.setMobile("mobile");
        userDataEntity.setPhone("phone");
        userDataEntity.setSalutationEntity(new SalutationEntity("Salutation"));
        userDataEntity.setSexEntity(new SexEntity("sex"));
        userDataEntity.setUserEntity(userEntity);
        userEntity.setUserData(userDataEntity);
        userRepository.save(userEntity);
    }
}
