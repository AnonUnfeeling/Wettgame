package com.jdroidcoder.persistent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by jdroidcoder on 25.01.17.
 */
@Entity
public class CategoryEntity extends AbstractEntity<Long>{
    private static final long serialVersionUID = 2222473597761021815L;

    @Column
    private String name;
    @Column
    private int isSystem;

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
}
