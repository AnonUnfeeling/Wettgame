package com.jdroidcoder.service.serviceimpl;

import com.jdroidcoder.persistent.dto.AddressDto;
import com.jdroidcoder.persistent.dto.CountryDto;
import com.jdroidcoder.persistent.dto.UserDto;
import com.jdroidcoder.persistent.entity.*;
import com.jdroidcoder.service.AddressService;
import com.jdroidcoder.service.GroupService;
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
public class AddressServiceImplTest {
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;
    private UserDto userEntity;
    private AddressDto addressDto;

    @Before
    public void setUp() {
        userEntity = new UserDto();
        userEntity.setEmail("Email2");
        userEntity.setUsername("username2");
        userEntity.setActivationCode("act-code");
        userEntity.setPassword("password");
        userEntity.setActive(1);
        userEntity.setBlocked(0);
        UserDataEntity userDataEntity = new UserDataEntity();
        userDataEntity.setAboutMe("about me2");
        userDataEntity.setLanguageEntity(new LanguageEntity("ENG"));
        userDataEntity.setBirthday(LocalDate.now());
        userDataEntity.setFirstName("firstName2");
        userDataEntity.setLastName("lastName2");
        userDataEntity.setLuckyNumber(123);
        userDataEntity.setMobile("mobile2");
        userDataEntity.setPhone("phone2");
        userDataEntity.setSalutationEntity(new SalutationEntity("Salutation2"));
        userDataEntity.setSexEntity(new SexEntity("sex2"));
        userEntity.setUserDataEntity(userDataEntity);
        userService.createUser(userEntity);

        addressDto = new AddressDto("street1", "zip1", "city1", new CountryDto("country1"));
    }

    @After
    public void clear() {
        userService.removeByID(userService.getUserByName(userEntity.getUsername()).getId());
    }

    @Test
    public void addAddressForUser() throws Exception {
        addressService.addAddressForUser(addressDto, userEntity);
        AddressEntity addressEntity = userService.getUserByName(userEntity.getUsername()).getUserData().getAddressEntity();
        assertTrue(addressEntity.getCity().equals(addressDto.getCity()));
        assertTrue(addressEntity.getStreet().equals(addressDto.getStreet()));
        assertTrue(addressEntity.getZipcode().equals(addressDto.getZipcode()));
        assertTrue(addressEntity.getCountryEntity().getName().equals(addressDto.getCountryDto().getName()));
    }

    @Test(expected = Exception.class)
    public void removeAddress() throws Exception {
        addressService.removeAddress(userEntity);
    }

    @Test(expected = Exception.class)
    public void getAddressByUser() throws Exception {
        AddressEntity addressEntity = userService.getUserByName(userEntity.getUsername()).getUserData().getAddressEntity();
        assertTrue(addressEntity.getCity().equals(addressDto.getCity()));
        assertTrue(addressEntity.getStreet().equals(addressDto.getStreet()));
        assertTrue(addressEntity.getZipcode().equals(addressDto.getZipcode()));
        assertTrue(addressEntity.getCountryEntity().getName().equals(addressDto.getCountryDto().getName()));
    }

}