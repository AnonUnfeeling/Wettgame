package com.jdroidcoder.persistent.dto;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by jdroidcoder on 24.01.17.
 */
public class LanguageDto {
    @NotEmpty(message = "Language name can not be empty")
    private String name;

    public LanguageDto() {
    }

    public LanguageDto(String name) {
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
        return "LanguageDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
