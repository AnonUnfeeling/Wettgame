package com.jdroidcoder.persistent.entity;

import javax.persistence.*;

/**
 * Created by jdroidcoder on 23.01.17.
 */
@Entity
//@Table(name = "salutation")
public class SalutationEntity extends AbstractEntity<Long> {
    private static final long serialVersionUID = 7222473597760218151L;

    @Column(nullable = false, unique = true)
    private String name;
    @OneToOne
    private UserDataEntity userDataEntity;

    public SalutationEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDataEntity getUserDataEntity() {
        return userDataEntity;
    }

    public void setUserDataEntity(UserDataEntity userDataEntity) {
        this.userDataEntity = userDataEntity;
    }

    @Override
    public String toString() {
        return "SalutationEntity{" +
                "name='" + name + '\'' +
                ", userDataEntity=" + userDataEntity +
                '}';
    }
}
