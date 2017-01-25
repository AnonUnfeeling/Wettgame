package com.jdroidcoder.service;

import com.jdroidcoder.persistent.dto.GroupDto;
import com.jdroidcoder.persistent.dto.UserDto;
import com.jdroidcoder.persistent.entity.UsersGroupEntity;

import java.util.List;

/**
 * Created by jdroidcoder on 25.01.17.
 */
public interface UsersGroupService {
    void setUserToGroup(UserDto userDto, GroupDto groupDto);

    List<UsersGroupEntity> getAllGroups();

    void removeUserFromGroup(UserDto userDto);
}
