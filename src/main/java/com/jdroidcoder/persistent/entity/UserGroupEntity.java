package com.jdroidcoder.persistent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by jdroidcoder on 24.01.17.
 */
@Entity
public class UserGroupEntity extends AbstractEntity<Long>{
    private static final long serialVersionUID = 7222453597761021815L;
    @Column
    private String name;
    @OneToOne
    private UsersGroupEntity usersGroup;

    public UserGroupEntity() {
    }

    public UserGroupEntity(String name) {
        this.name = name;
    }

    public UsersGroupEntity getUsersGroup() {
        return usersGroup;
    }

    public void setUsersGroup(UsersGroupEntity usersGroup) {
        this.usersGroup = usersGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserGroupEntity)) return false;
        if (!super.equals(o)) return false;

        UserGroupEntity userGroupEntity = (UserGroupEntity) o;

        return getName() != null ? getName().equals(userGroupEntity.getName()) : userGroupEntity.getName() == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
