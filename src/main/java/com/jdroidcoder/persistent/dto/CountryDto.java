package com.jdroidcoder.persistent.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by jdroidcoder on 24.01.17.
 */
public class CountryDto {
    @NotEmpty(message = "Country can not be empty")
    @Size(max = 45, message = "Country is too long (maximum is 45 characters)")
    private String name;

    public CountryDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CountryDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
