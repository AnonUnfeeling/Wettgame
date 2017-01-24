package com.jdroidcoder.service;

import com.jdroidcoder.persistent.dto.AddressDto;
import com.jdroidcoder.persistent.dto.UserDto;
import com.jdroidcoder.persistent.entity.AddressEntity;

/**
 * Created by jdroidcoder on 24.01.17.
 */
public interface AddressService {
    void addAddressForUser(AddressDto addressDto, UserDto userDto);
    void removeAddress(UserDto userDto);
    AddressEntity getAddressByUser(UserDto userDto);
}
