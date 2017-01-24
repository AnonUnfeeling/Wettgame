package com.jdroidcoder.service.serviceimpl;

import com.jdroidcoder.persistent.dto.*;
import com.jdroidcoder.persistent.entity.*;
import com.jdroidcoder.persistent.repository.UserDataRepository;
import com.jdroidcoder.service.UserDataService;
import com.jdroidcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by jdroidcoder on 24.01.17.
 */
@Service
public class UserDataServiceImpl implements UserDataService {
    private UserDataRepository userDataRepository;
    private UserService userService;
    private Logger logger = Logger.getLogger(UserDataServiceImpl.class.getName());

    @Autowired
    public UserDataServiceImpl(UserDataRepository userDataRepository, UserService userService) {
        this.userDataRepository = userDataRepository;
        this.userService = userService;
    }

    @Override
    public void setUserDetails(String username, UserDataDto userDataDto) {
        UserEntity userEntity = userService.getUserByName(username);
        userEntity.setUserData(convertDtoToEntity(userDataDto));
        userService.createUser(userEntity);
    }

    @Override
    public UserDataDto getUserInfo(String username) {
        return convertEntityToDto(userService.getUserByName(username).getUserData());
    }

    @Override
    public void removeUserInfo(Long id) {
        userDataRepository.delete(id);
    }

    private UserDataDto convertEntityToDto(UserDataEntity userDataDto) {
        UserDataDto userDataEntity = new UserDataDto();
        userDataEntity.setFirstName(userDataDto.getFirstName());
        userDataEntity.setAboutMe(userDataDto.getAboutMe());
        userDataEntity.setBirthday(userDataDto.getBirthday());
        userDataEntity.setLastName(userDataDto.getLastName());
        userDataEntity.setLuckyNumber(userDataDto.getLuckyNumber());
        userDataEntity.setMobile(userDataDto.getMobile());
        userDataEntity.setPhone(userDataDto.getPhone());
        userDataEntity.setAddressEntity(convertAddressEntityToDto(userDataDto.getAddressEntity()));
        userDataEntity.setLanguageEntity(new LanguageDto(userDataDto.getLanguageEntity().getName()));
        userDataEntity.setSalutationEntity(new SalutationDto(userDataDto.getSalutationEntity().getName()));
        userDataEntity.setSexEntity(new SexDto(userDataDto.getSexEntity().getName()));
        return userDataEntity;
    }

    private UserDataEntity convertDtoToEntity(UserDataDto userDataDto) {
        UserDataEntity userDataEntity = new UserDataEntity();
        userDataEntity.setFirstName(userDataDto.getFirstName());
        userDataEntity.setAboutMe(userDataDto.getAboutMe());
        userDataEntity.setBirthday(userDataDto.getBirthday());
        userDataEntity.setLastName(userDataDto.getLastName());
        userDataEntity.setLuckyNumber(userDataDto.getLuckyNumber());
        userDataEntity.setMobile(userDataDto.getMobile());
        userDataEntity.setPhone(userDataDto.getPhone());
        userDataEntity.setAddressEntity(convertAddressToEntity(userDataDto.getAddressEntity()));
        userDataEntity.setLanguageEntity(new LanguageEntity(userDataDto.getLanguageEntity().getName()));
        userDataEntity.setSalutationEntity(new SalutationEntity(userDataDto.getSalutationEntity().getName()));
        userDataEntity.setSexEntity(new SexEntity(userDataDto.getSexEntity().getName()));
        return userDataEntity;
    }

    private AddressDto convertAddressEntityToDto(AddressEntity addressDto) {
        AddressDto addressEntity = new AddressDto();
        try {
            addressEntity.setCity(addressDto.getCity());
            addressEntity.setStreet(addressDto.getStreet());
            addressEntity.setZipcode(addressDto.getZipcode());
            addressEntity.setCountryDto(new CountryDto(addressDto.getCountryEntity().getName()));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "convertAddressEntityToDto", e);
        }
        return addressEntity;
    }

    private AddressEntity convertAddressToEntity(AddressDto addressDto) {
        AddressEntity addressEntity = new AddressEntity();
        try {
            addressEntity.setCity(addressDto.getCity());
            addressEntity.setStreet(addressDto.getStreet());
            addressEntity.setZipcode(addressDto.getZipcode());
            addressEntity.setCountryEntity(new CountryEntity(addressDto.getCountryDto().getName()));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "convertAddressToEntity", e);
        }
        return addressEntity;
    }
}
