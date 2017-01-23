package com.jdroidcoder.persistent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by jdroidcoder on 24.01.17.
 */
@Entity
public class UserGroup extends AbstractEntity<Long>{
    @Column
    private String name;

    public UserGroup() {
    }

    public UserGroup(String name) {
        this.name = name;
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
        if (!(o instanceof UserGroup)) return false;
        if (!super.equals(o)) return false;

        UserGroup userGroup = (UserGroup) o;

        return getName() != null ? getName().equals(userGroup.getName()) : userGroup.getName() == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
