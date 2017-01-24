package com.jdroidcoder.persistent.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by jdroidcoder on 23.01.17.
 */
@Entity
//@Table(name = "user_data")
public class UserDataEntity extends AbstractEntity<Long> {
    private static final long serialVersionUID = 7222473597761021815L;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "lucky_number")
    private int luckyNumber;
    @Column(name = "about_me", length = 500)
    private String aboutMe;
    @Column(name = "birthday")
    private LocalDate birthday;
    @OneToOne
    private UserEntity userEntity;
    @OneToOne(cascade = CascadeType.ALL)
    private SalutationEntity salutationEntity;
    @OneToOne(cascade = CascadeType.ALL)
    private SexEntity sexEntity;
    @OneToOne(cascade = CascadeType.ALL)
    private LanguageEntity languageEntity;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getLuckyNumber() {
        return luckyNumber;
    }

    public void setLuckyNumber(int luckyNumber) {
        this.luckyNumber = luckyNumber;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public SalutationEntity getSalutationEntity() {
        return salutationEntity;
    }

    public void setSalutationEntity(SalutationEntity salutationEntity) {
        this.salutationEntity = salutationEntity;
    }

    public SexEntity getSexEntity() {
        return sexEntity;
    }

    public void setSexEntity(SexEntity sexEntity) {
        this.sexEntity = sexEntity;
    }

    public LanguageEntity getLanguageEntity() {
        return languageEntity;
    }

    public void setLanguageEntity(LanguageEntity languageEntity) {
        this.languageEntity = languageEntity;
    }

    @Override
    public String toString() {
        return "UserDataEntity{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", luckyNumber=" + luckyNumber +
                ", aboutMe='" + aboutMe + '\'' +
                ", birthday=" + birthday +
                ", userEntity=" + userEntity +
                ", salutationEntity=" + salutationEntity +
                ", sexEntity=" + sexEntity +
                ", languageEntity=" + languageEntity +
                '}';
    }
}
