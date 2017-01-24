package com.jdroidcoder.service.serviceimpl;

import com.jdroidcoder.persistent.dto.*;
import com.jdroidcoder.persistent.entity.LanguageEntity;
import com.jdroidcoder.persistent.entity.SalutationEntity;
import com.jdroidcoder.persistent.entity.SexEntity;
import com.jdroidcoder.persistent.entity.UserDataEntity;
import com.jdroidcoder.service.UserDataService;
import com.jdroidcoder.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by jdroidcoder on 24.01.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDataServiceImplTest {
    @Autowired
    private UserDataService userDataService;
    @Autowired
    private UserService userService;
    private UserDto userEntity;
    private UserDataDto userDataEntity;

    @Before
    public void init() {
        userEntity = new UserDto();
        userEntity.setEmail("Email2");
        userEntity.setUsername("username2");
        userEntity.setActivationCode("act-code");
        userEntity.setPassword("password");
        userEntity.setActive(1);
        userEntity.setBlocked(0);

        userService.createUser(userEntity);
        userDataEntity = new UserDataDto();
        userDataEntity.setAboutMe("about me2");
        userDataEntity.setLanguageEntity(new LanguageDto("ENG2"));
        userDataEntity.setBirthday(LocalDate.now());
        userDataEntity.setFirstName("firstName2");
        userDataEntity.setLastName("lastName2");
        userDataEntity.setLuckyNumber(123);
        userDataEntity.setMobile("mobile2");
        userDataEntity.setPhone("phone2");
        userDataEntity.setSalutationEntity(new SalutationDto("Salutation2"));
        userDataEntity.setSexEntity(new SexDto("sex2"));
        userDataService.setUserDetails(userEntity.getUsername(), userDataEntity);
    }

    @After
    public void clear() {
        userService.removeByID(userService.getUserByName(userEntity.getUsername()).getId());
    }

    @Test
    public void getUserInfo() throws Exception {
        assertTrue(userDataEntity.equals(userDataService.getUserInfo(userEntity.getUsername())));
    }
}