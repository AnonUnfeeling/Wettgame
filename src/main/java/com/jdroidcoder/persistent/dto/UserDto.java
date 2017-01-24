package com.jdroidcoder.persistent.dto;

import com.jdroidcoder.persistent.entity.UserDataEntity;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by jdroidcoder on 23.01.17.
 */
public class UserDto {
    @NotEmpty(message = "Email can not be empty")
    @Email
    private String email;
    @NotEmpty(message = "Username can not be empty")
    private String username;
    @NotEmpty(message = "Password can not be empty")
    private String password;
    private int active;
    private int blocked;
    private String activationCode;
    private UserDataEntity userDataEntity;

    public UserDto() {
    }

    public UserDto(String email, String username, String password, int active, int blocked, String activationCode) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.active = active;
        this.blocked = blocked;
        this.activationCode = activationCode;
    }

    public UserDto(String email, String username, String password, int active,
                   int blocked, String activationCode, UserDataEntity userDataEntity) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.active = active;
        this.blocked = blocked;
        this.activationCode = activationCode;
        this.userDataEntity = userDataEntity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getBlocked() {
        return blocked;
    }

    public void setBlocked(int blocked) {
        this.blocked = blocked;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public UserDataEntity getUserDataEntity() {
        return userDataEntity;
    }

    public void setUserDataEntity(UserDataEntity userDataEntity) {
        this.userDataEntity = userDataEntity;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", blocked=" + blocked +
                ", activationCode='" + activationCode + '\'' +
                ", userDataEntity=" + userDataEntity +
                '}';
    }
}
