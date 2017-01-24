package com.jdroidcoder.persistent.dto;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by jdroidcoder on 24.01.17.
 */
public class SalutationDto {
    @NotEmpty(message = "Salutation name can not be empty")
    private String name;

    public SalutationDto() {
    }

    public SalutationDto(String name) {
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
        return "SalutationDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
