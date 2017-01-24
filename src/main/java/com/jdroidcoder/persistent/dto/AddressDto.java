package com.jdroidcoder.persistent.dto;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by jdroidcoder on 24.01.17.
 */
public class AddressDto {
    @NotEmpty(message = "Street can not be empty")
    @Size(max = 45, message = "Street is too long (maximum is 45 characters)")
    private String street;
    @NotEmpty(message = "Zip code can not be empty")
    @Size(max = 45, message = "Zip code is too long (maximum is 45 characters)")
    private String zipcode;
    @NotEmpty(message = "City can not be empty")
    @Size(max = 45, message = "City is too long (maximum is 45 characters)")
    private String city;
    private CountryDto countryDto;

    public AddressDto() {
    }

    public AddressDto(String street, String zipcode, String city, CountryDto countryDto) {
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.countryDto = countryDto;
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

    public CountryDto getCountryDto() {
        return countryDto;
    }

    public void setCountryDto(CountryDto countryDto) {
        this.countryDto = countryDto;
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "street='" + street + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                ", countryDto=" + countryDto +
                '}';
    }
}
