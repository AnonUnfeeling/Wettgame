package com.jdroidcoder.persistent.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by jdroidcoder on 24.01.17.
 */
@Entity
public class LocationEntity extends AbstractEntity<Long>{
    private static final long serialVersionUID = 7263373567761021815L;

    @Column
    private int type;
    @Column
    private String name;
    @Column
    public int isSystem;
    @OneToOne(cascade = CascadeType.ALL)
    private LocationTypeEntity locationTypeEntity;
    @OneToOne(cascade = CascadeType.ALL)
    private AddressEntity addressEntity;

    public LocationEntity() {
    }

    public LocationEntity(int type, String name, int isSystem, LocationTypeEntity locationTypeEntity, AddressEntity addressEntity) {
        this.type = type;
        this.name = name;
        this.isSystem = isSystem;
        this.locationTypeEntity = locationTypeEntity;
        this.addressEntity = addressEntity;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public LocationTypeEntity getLocationTypeEntity() {
        return locationTypeEntity;
    }

    public void setLocationTypeEntity(LocationTypeEntity locationTypeEntity) {
        this.locationTypeEntity = locationTypeEntity;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
}
