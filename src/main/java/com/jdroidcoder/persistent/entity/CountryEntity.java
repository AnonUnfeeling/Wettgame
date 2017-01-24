package com.jdroidcoder.persistent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by jdroidcoder on 24.01.17.
 */
@Entity
public class CountryEntity  extends AbstractEntity<Long>{
    private static final long serialVersionUID = 7223373597761021815L;

    @Column
    private String name;
    @OneToOne
    private AddressEntity addressEntity;

    public CountryEntity() {
    }

    public CountryEntity(String name, AddressEntity addressEntity) {
        this.name = name;
        this.addressEntity = addressEntity;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
