package com.jdroidcoder.persistent.dto;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by jdroidcoder on 25.01.17.
 */
public class GroupDto {
    @NotEmpty(message = "Group name can not be empty")
    private String name;

    public GroupDto() {
    }

    public GroupDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
