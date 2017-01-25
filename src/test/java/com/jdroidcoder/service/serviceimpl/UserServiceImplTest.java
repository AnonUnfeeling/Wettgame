package com.jdroidcoder.service.serviceimpl;

import com.jdroidcoder.persistent.SpringDataConfig;
import com.jdroidcoder.persistent.dto.UserDto;
import com.jdroidcoder.persistent.entity.*;
import com.jdroidcoder.persistent.repository.UserRepository;
import com.jdroidcoder.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by jdroidcoder on 23.01.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataConfig.class})
@ActiveProfiles("test")
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    private UserDto userEntity;

    @Before
    public void setUp(){
        userEntity = new UserDto();
        userEntity.setEmail("Email1");
        userEntity.setUsername("username1");
        userEntity.setActivationCode("act-code");
        userEntity.setPassword("password");
        userEntity.setActive(1);
        userEntity.setBlocked(0);
        UserDataEntity userDataEntity = new UserDataEntity();
        userDataEntity.setAboutMe("about me1");
        userDataEntity.setLanguageEntity(new LanguageEntity("ENG1"));
        userDataEntity.setBirthday(LocalDate.now());
        userDataEntity.setFirstName("firstName1");
        userDataEntity.setLastName("lastName1");
        userDataEntity.setLuckyNumber(123);
        userDataEntity.setMobile("mobile1");
        userDataEntity.setPhone("phone1");
        userDataEntity.setSalutationEntity(new SalutationEntity("Salutation1"));
        userDataEntity.setSexEntity(new SexEntity("sex1"));
        userEntity.setUserDataEntity(userDataEntity);

        userService.createUser(userEntity);
    }

    @Test
    public void getUserByName() throws Exception {
        assertTrue(userEntity.getEmail().equals(userService.getUserByName("username1").getEmail()));
    }

    @After
    public void clear(){
        userService.removeByID(userService.getUserByName("username1").getId());
    }
}