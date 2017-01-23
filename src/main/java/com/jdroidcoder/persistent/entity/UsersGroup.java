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
public class UsersGroup extends AbstractEntity<Long>{
    @OneToOne(cascade = CascadeType.ALL)
    private UserGroup userGroup;

    @OneToMany(mappedBy = "usersGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserEntity> userEntities = new ArrayList<>();

    public UsersGroup() {
    }

    public UsersGroup(UserGroup userGroup, List<UserEntity> userEntities) {
        this.userGroup = userGroup;
        this.userEntities = userEntities;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public List<UserEntity> getUsersGroup() {
        return userEntities;
    }

    public void setUsersGroup(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }
}
