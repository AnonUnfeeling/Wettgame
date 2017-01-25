package com.jdroidcoder.persistent.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by jdroidcoder on 25.01.17.
 */
@Entity
public class EventEntity extends AbstractEntity<Long> {
    private static final long serialVersionUID = 9222473597761021815L;

    @Column
    private String name;
    @Column
    private int isSystem;
    @OneToOne(cascade = CascadeType.ALL)
    private SportEntity sportEntity;

    public EventEntity() {
    }

    public EventEntity(String name, int isSystem, SportEntity sportEntity) {
        this.name = name;
        this.isSystem = isSystem;
        this.sportEntity = sportEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(int isSystem) {
        this.isSystem = isSystem;
    }

    public SportEntity getSportEntity() {
        return sportEntity;
    }

    public void setSportEntity(SportEntity sportEntity) {
        this.sportEntity = sportEntity;
    }
}
