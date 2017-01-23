package com.jdroidcoder.persistent.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jdroidcoder on 24.01.17.
 */
@Entity
public class UsersGroupEntity extends AbstractEntity<Long>{
    @OneToOne(cascade = CascadeType.ALL)
    private UserGroupEntity userGroupEntity;

    @OneToMany(mappedBy = "usersGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserEntity> userEntities = new ArrayList<>();

    public UsersGroupEntity() {
    }

    public UsersGroupEntity(UserGroupEntity userGroupEntity, List<UserEntity> userEntities) {
        this.userGroupEntity = userGroupEntity;
        this.userEntities = userEntities;
    }

    public UserGroupEntity getUserGroupEntity() {
        return userGroupEntity;
    }

    public void setUserGroupEntity(UserGroupEntity userGroupEntity) {
        this.userGroupEntity = userGroupEntity;
    }

    public List<UserEntity> getUsersGroup() {
        return userEntities;
    }

    public void setUsersGroup(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }
}
