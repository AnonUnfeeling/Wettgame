package com.jdroidcoder.persistent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by jdroidcoder on 23.01.17.
 */
@Entity
//@Table(name = "sex")
public class SexEntity extends AbstractEntity<Long> {
    private static final long serialVersionUID = 7222473597761021815L;

    @Column(nullable = false, unique = true)
    private String name;
    @OneToOne
    private UserDataEntity userDataEntity;

    public SexEntity() {
    }

    public SexEntity(String name) {
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
        return "SexEntity{" +
                "name='" + name + '\'' +
                ", userDataEntity=" + userDataEntity +
                '}';
    }
}
