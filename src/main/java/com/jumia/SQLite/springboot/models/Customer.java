package com.jumia.SQLite.springboot.models;

import javax.persistence.*;


@Entity(name = "customer")
public class Customer {

    //to automatically define the id of the current row in incremental order
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phoneNumber;
    private String country;


    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        country = CountryCode.getCountry(getCountryCodeNumber()).getName();
        return country;
    }

    public String getCountryCodeNumber() {
        try {
            return phoneNumber.substring(1, 4);
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
