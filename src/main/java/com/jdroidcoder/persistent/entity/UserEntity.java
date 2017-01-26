package com.jdroidcoder.persistent.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by jdroidcoder on 23.01.17.
 */
@Entity
//@Table(name = "user")
public class UserEntity extends AbstractEntity<Long> implements UserDetails {
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
    @OneToOne(cascade = CascadeType.ALL)
    private UserDataEntity userDataEntity;
    @ManyToOne
    private UsersGroupEntity usersGroup;
    @OneToOne
    private UserTipEntity userTipEntity;

    public UsersGroupEntity getUsersGroup() {
        return usersGroup;
    }

    public void setUsersGroup(UsersGroupEntity usersGroup) {
        this.usersGroup = usersGroup;
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

    public UserDataEntity getUserData() {
        return userDataEntity;
    }

    public void setUserData(UserDataEntity userData) {
        this.userDataEntity = userData;
    }

    public UserDataEntity getUserDataEntity() {
        return userDataEntity;
    }

    public void setUserDataEntity(UserDataEntity userDataEntity) {
        this.userDataEntity = userDataEntity;
    }

    public UserTipEntity getUserTipEntity() {
        return userTipEntity;
    }

    public void setUserTipEntity(UserTipEntity userTipEntity) {
        this.userTipEntity = userTipEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        if (!super.equals(o)) return false;

        UserEntity that = (UserEntity) o;

        if (getActive() != that.getActive()) return false;
        if (getBlocked() != that.getBlocked()) return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getUsername() != null ? !getUsername().equals(that.getUsername()) : that.getUsername() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(that.getPassword()) : that.getPassword() != null)
            return false;
        if (getActivationCode() != null ? !getActivationCode().equals(that.getActivationCode()) : that.getActivationCode() != null)
            return false;
        return userDataEntity != null ? userDataEntity.equals(that.userDataEntity) : that.userDataEntity == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + getActive();
        result = 31 * result + getBlocked();
        result = 31 * result + (getActivationCode() != null ? getActivationCode().hashCode() : 0);
        result = 31 * result + (userDataEntity != null ? userDataEntity.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", blocked=" + blocked +
                ", activationCode='" + activationCode + '\'' +
                ", userDataEntity=" + userDataEntity +
                '}';
    }

    //    Security
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (isAccountNonExpired() && isAccountNonLocked() && isCredentialsNonExpired() && isEnabled()) {
            authorities.add(new SimpleGrantedAuthority("USER"));
        }
        return authorities;
    }
}
