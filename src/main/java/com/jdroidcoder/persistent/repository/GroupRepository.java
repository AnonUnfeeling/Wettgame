package com.jdroidcoder.persistent.repository;

import com.jdroidcoder.persistent.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jdroidcoder on 24.01.17.
 */
public interface GroupRepository extends CrudRepository<UserEntity, Long> {
}
