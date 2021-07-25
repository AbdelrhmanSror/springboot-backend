package com.jumia.SQLite.springboot.entity;


public class Country {
    private final String phoneRegex;
    private final String name;
    public Country(String name,String phoneRegex) {
        this.phoneRegex = phoneRegex;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public String getCodeRegex() {
        try {
            return phoneRegex.substring(2, 5);
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    public String getPhoneRegex() {
        return phoneRegex;
    }
}
