package com.jdroidcoder.service.serviceimpl;

import com.jdroidcoder.persistent.entity.UserGroupEntity;
import com.jdroidcoder.persistent.repository.GroupRepository;
import com.jdroidcoder.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jdroidcoder on 24.01.17.
 */
@Service
public class GroupServiceImpl implements GroupService {
    private GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public UserGroupEntity createGroup(String groupName) {
        return groupRepository.save(new UserGroupEntity(groupName));
    }

    @Override
    public List<UserGroupEntity> getAllGroups() {
        return (List<UserGroupEntity>) groupRepository.findAll();
    }

    @Override
    public void removeGroup(String groupName) {
        groupRepository.delete(groupRepository.findByName(groupName));
    }

    @Override
    public UserGroupEntity getGroupByName(String groupName) {
        return groupRepository.findByName(groupName);
    }

}
