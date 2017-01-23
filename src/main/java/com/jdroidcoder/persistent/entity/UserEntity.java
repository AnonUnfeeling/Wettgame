package com.jdroidcoder.persistent.entity;

import javax.persistence.*;

/**
 * Created by jdroidcoder on 23.01.17.
 */
@Entity
//@Table(name = "user")
public class UserEntity extends AbstractEntity<Long> {
    private static final long serialVersionUID = 7222473597761021815L;

    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private int active;
    @Column(nullable = false)
    private int blocked;
    @Column(name = "activation_code", nullable = false)
    private String activationCode;
    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserDataEntity userDataEntity;

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

    public UserDataEntity getUserData() {
        return userDataEntity;
    }

    public void setUserData(UserDataEntity userData) {
        this.userDataEntity = userData;
    }
}
