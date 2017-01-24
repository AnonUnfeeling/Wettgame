package com.jdroidcoder.service.serviceimpl;

import com.jdroidcoder.persistent.dto.AddressDto;
import com.jdroidcoder.persistent.dto.UserDataDto;
import com.jdroidcoder.persistent.dto.UserDto;
import com.jdroidcoder.persistent.entity.*;
import com.jdroidcoder.persistent.repository.UserDataRepository;
import com.jdroidcoder.service.UserDataService;
import com.jdroidcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jdroidcoder on 24.01.17.
 */
@Service
public class UserDataServiceImpl implements UserDataService{
    private UserDataRepository userDataRepository;
    private UserService userService;
    @Autowired
    public UserDataServiceImpl(UserDataRepository userDataRepository, UserService userService) {
        this.userDataRepository = userDataRepository;
        this.userService = userService;
    }

    @Override
    public void setUserDetails(String username, UserDataDto userDataDto) {
        UserEntity userEntity = userService.getUserByName(username);
        UserDataEntity userDataEntity = convertDtoToEntity(userDataDto);
        userDataEntity.setUserEntity(userEntity);
        userDataRepository.save(userDataEntity);
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

    private AddressEntity convertAddressToEntity(AddressDto addressDto) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCity(addressDto.getCity());
        addressEntity.setStreet(addressDto.getStreet());
        addressEntity.setZipcode(addressDto.getZipcode());
        addressEntity.setCountryEntity(new CountryEntity(addressDto.getCountryDto().getName()));
        return addressEntity;
    }
}
