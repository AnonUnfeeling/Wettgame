package com.jdroidcoder.service.serviceimpl;

import com.jdroidcoder.persistent.dto.AddressDto;
import com.jdroidcoder.persistent.dto.CountryDto;
import com.jdroidcoder.persistent.dto.UserDto;
import com.jdroidcoder.persistent.entity.AddressEntity;
import com.jdroidcoder.persistent.entity.CountryEntity;
import com.jdroidcoder.persistent.entity.UserDataEntity;
import com.jdroidcoder.persistent.entity.UserEntity;
import com.jdroidcoder.persistent.repository.AddressRepository;
import com.jdroidcoder.persistent.repository.UserRepository;
import com.jdroidcoder.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jdroidcoder on 24.01.17.
 */
@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    private UserRepository userRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addAddressForUser(AddressDto addressDto, UserDto userDto) {
        UserEntity userEntity = userRepository.findByUsername(userDto.getUsername());
        UserDataEntity userDataEntity = userEntity.getUserData();
        userDataEntity.setAddressEntity(convertDtoToEntity(addressDto));
        userEntity.setUserData(userDataEntity);
        userRepository.save(userEntity);
    }

    @Override
    public void removeAddress(UserDto userDto) {
        addressRepository.delete(userRepository.findByUsername(userDto.getUsername()).getUserData().getAddressEntity());
    }

    @Override
    public AddressEntity getAddressByUser(UserDto userDto) {
        return userRepository.findByUsername(userDto.getUsername()).getUserData().getAddressEntity();
    }

    private AddressEntity convertDtoToEntity(AddressDto addressDto) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCity(addressDto.getCity());
        addressEntity.setStreet(addressDto.getStreet());
        addressEntity.setZipcode(addressDto.getZipcode());
        addressEntity.setCountryEntity(convertCountryDtoToEntity(addressDto.getCountryDto()));
        return addressEntity;
    }

    private CountryEntity convertCountryDtoToEntity(CountryDto countryDto) {
        return new CountryEntity(countryDto.getName());
    }
}
