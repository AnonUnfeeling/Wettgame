package com.jdroidcoder.persistent.dto;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Created by jdroidcoder on 24.01.17.
 */
public class UserDataDto {
    @NotEmpty(message = "First name can not be empty")
    private String firstName;
    @NotEmpty(message = "Last name can not be empty")
    private String lastName;
    private String phone;
    private String mobile;
    private int luckyNumber;
    @Size(max = 500, message = "About me is too long (maximum is 45 characters)")
    private String aboutMe;
    private LocalDate birthday;
    private SalutationDto salutationEntity;
    private SexDto sexEntity;
    private LanguageDto languageEntity;
    private AddressDto addressEntity;


    public UserDataDto() {
    }

    public UserDataDto(String firstName, String lastName, String phone, String mobile, int luckyNumber, String aboutMe, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.mobile = mobile;
        this.luckyNumber = luckyNumber;
        this.aboutMe = aboutMe;
        this.birthday = birthday;
    }

    public UserDataDto(String firstName, String lastName, String phone, String mobile,
                       int luckyNumber, String aboutMe, LocalDate birthday, SalutationDto salutationEntity,
                       SexDto sexEntity, LanguageDto languageEntity, AddressDto addressEntity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.mobile = mobile;
        this.luckyNumber = luckyNumber;
        this.aboutMe = aboutMe;
        this.birthday = birthday;
        this.salutationEntity = salutationEntity;
        this.sexEntity = sexEntity;
        this.languageEntity = languageEntity;
        this.addressEntity = addressEntity;
    }

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

    public SalutationDto getSalutationEntity() {
        return salutationEntity;
    }

    public void setSalutationEntity(SalutationDto salutationEntity) {
        this.salutationEntity = salutationEntity;
    }

    public SexDto getSexEntity() {
        return sexEntity;
    }

    public void setSexEntity(SexDto sexEntity) {
        this.sexEntity = sexEntity;
    }

    public LanguageDto getLanguageEntity() {
        return languageEntity;
    }

    public void setLanguageEntity(LanguageDto languageEntity) {
        this.languageEntity = languageEntity;
    }

    public AddressDto getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressDto addressEntity) {
        this.addressEntity = addressEntity;
    }

    @Override
    public String toString() {
        return "UserDataDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", luckyNumber=" + luckyNumber +
                ", aboutMe='" + aboutMe + '\'' +
                ", birthday=" + birthday +
                ", salutationEntity=" + salutationEntity +
                ", sexEntity=" + sexEntity +
                ", languageEntity=" + languageEntity +
                ", addressEntity=" + addressEntity +
                '}';
    }
}
