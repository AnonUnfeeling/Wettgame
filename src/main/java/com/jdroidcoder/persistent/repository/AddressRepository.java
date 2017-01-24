package com.jdroidcoder.persistent.repository;

import com.jdroidcoder.persistent.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jdroidcoder on 24.01.17.
 */
public interface AddressRepository extends CrudRepository<AddressEntity,Long> {
}
