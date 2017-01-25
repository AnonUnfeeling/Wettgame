package com.jdroidcoder.service.serviceimpl;

import com.jdroidcoder.persistent.dto.GroupDto;
import com.jdroidcoder.persistent.dto.UserDto;
import com.jdroidcoder.persistent.entity.UserEntity;
import com.jdroidcoder.persistent.entity.UserGroupEntity;
import com.jdroidcoder.persistent.entity.UsersGroupEntity;
import com.jdroidcoder.persistent.repository.UsersGroupRepository;
import com.jdroidcoder.service.GroupService;
import com.jdroidcoder.service.UserService;
import com.jdroidcoder.service.UsersGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jdroidcoder on 25.01.17.
 */
@Service
public class UsersGroupServiceImpl implements UsersGroupService {
    private UsersGroupRepository usersGroupRepository;
    private UserService userService;
    private GroupService groupService;

    @Autowired
    public UsersGroupServiceImpl(UsersGroupRepository usersGroupRepository, UserService userService,
                                 GroupService groupService) {
        this.usersGroupRepository = usersGroupRepository;
        this.userService = userService;
        this.groupService = groupService;
    }


    @Override
    public void setUserToGroup(UserDto userDto, GroupDto groupDto) {
        UsersGroupEntity usersGroupEntity = new UsersGroupEntity();
        usersGroupEntity.setUserGroupEntity(groupService.getGroupByName(groupDto.getName()));
        usersGroupEntity.getUsersGroup().add(userService.getUserByName(userDto.getUsername()));
        usersGroupRepository.save(usersGroupEntity);
    }

    @Override
    public List<UsersGroupEntity> getAllGroups() {
        return (List<UsersGroupEntity>) usersGroupRepository.findAll();
    }

    @Override
    public void removeUserFromGroup(UserDto userDto) {

    }
}
