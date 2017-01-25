package com.jdroidcoder.persistent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by jdroidcoder on 25.01.17.
 */
@Entity
public class GameSectorEntity extends AbstractEntity<Long>{
    private static final long serialVersionUID = 2222473597761021815L;

    @Column
    private String name;

    @OneToOne
    private GameSectorEntity gameSectorEntity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
