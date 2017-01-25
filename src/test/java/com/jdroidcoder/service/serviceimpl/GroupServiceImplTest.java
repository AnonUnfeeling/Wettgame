package com.jdroidcoder.service.serviceimpl;

import com.jdroidcoder.persistent.entity.UserGroupEntity;
import com.jdroidcoder.service.GroupService;
import com.jdroidcoder.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by jdroidcoder on 24.01.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupServiceImplTest {
    @Autowired
    private GroupService groupService;
    private UserGroupEntity userGroupEntity;

    @Before
    public void setUp() throws Exception {
        userGroupEntity = groupService.createGroup("testGroup");
    }

    @Test
    public void createGroup(){
        assertTrue(groupService.getAllGroups().stream().filter(p->p.equals(userGroupEntity)).findFirst().isPresent());
    }

    @Test
    public void getAllGroups() throws Exception {
        assertTrue(groupService.getAllGroups().size() > 0);
    }

    @After
    public void clear(){
        groupService.removeGroup(userGroupEntity.getName());
        assertFalse(groupService.getAllGroups().stream().filter(p->p.equals(userGroupEntity)).findFirst().isPresent());
    }
}