package com.jdroidcoder.persistent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by jdroidcoder on 24.01.17.
 */
@Entity
public class LocationTypeEntity extends AbstractEntity<Long> {
    private static final long serialVersionUID = 7223373567761021815L;

    @Column
    private String name;
    @OneToOne
    private LocationEntity locationEntity;

    public LocationTypeEntity() {
    }

    public LocationTypeEntity(String name, LocationEntity locationEntity) {
        this.name = name;
        this.locationEntity = locationEntity;
    }

    public LocationEntity getLocationEntity() {
        return locationEntity;
    }

    public void setLocationEntity(LocationEntity locationEntity) {
        this.locationEntity = locationEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
