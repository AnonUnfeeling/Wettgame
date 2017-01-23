package com.jdroidcoder.service;

import com.jdroidcoder.persistent.entity.UserEntity;

/**
 * Created by jdroidcoder on 23.01.17.
 */
public interface UserService {
    Iterable<UserEntity> getAllUser();
}
