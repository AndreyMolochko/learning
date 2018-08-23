package com.example.user.roomandroid.room.bd;

import android.arch.persistence.room.Ignore;

/**
 * Created by User on 23.08.2018.
 */

public class Location {
    private String city;
    private String country;
    private String street;

    public Location(String city, String country, String street) {
        this.city = city;
        this.country = country;
        this.street = street;
    }

    @Ignore
    public Location() {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
