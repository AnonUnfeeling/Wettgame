package com.jdroidcoder.persistent.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by jdroidcoder on 24.01.17.
 */
@Entity
public class AddressEntity extends AbstractEntity<Long> {
    private static final long serialVersionUID = 7223373597761021815L;

    @Column
    private String street;
    @Column
    private String zipcode;
    @Column
    private String city;
    @OneToOne(cascade = CascadeType.ALL)
    private CountryEntity countryEntity;

    public AddressEntity() {
    }

    public AddressEntity(String street, String zipcode, String city, CountryEntity countryEntity) {
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.countryEntity = countryEntity;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CountryEntity getCountryEntity() {
        return countryEntity;
    }

    public void setCountryEntity(CountryEntity countryEntity) {
        this.countryEntity = countryEntity;
    }
}
