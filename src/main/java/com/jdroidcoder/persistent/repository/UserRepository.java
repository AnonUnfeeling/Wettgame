package com.jdroidcoder.persistent.repository;

import com.jdroidcoder.persistent.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jdroidcoder on 23.01.17.
 */
public interface UserRepository extends CrudRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);
}
