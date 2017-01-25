package com.jdroidcoder.service;

import com.jdroidcoder.persistent.entity.UserGroupEntity;

import java.util.List;

/**
 * Created by jdroidcoder on 24.01.17.
 */
public interface GroupService {
    UserGroupEntity createGroup(String groupName);

    List<UserGroupEntity> getAllGroups();

    void removeGroup(String groupName);

}
