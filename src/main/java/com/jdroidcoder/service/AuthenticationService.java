package com.jdroidcoder.service;

import com.jdroidcoder.persistent.entity.UserEntity;

import java.util.List;

/**
 * Created by jdroidcoder on 24.01.17.
 */
public interface AuthenticationService {
    UserEntity getPrincipal();

    List<String> getUserRoles();
}
