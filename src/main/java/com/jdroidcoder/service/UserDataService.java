package com.jdroidcoder.service;

import com.jdroidcoder.persistent.dto.UserDataDto;

/**
 * Created by jdroidcoder on 24.01.17.
 */
public interface UserDataService {
    void setUserDetails(String username, UserDataDto userDataDto);

    UserDataDto getUserInfo(String username);

    void removeUserInfo(Long id);
}
