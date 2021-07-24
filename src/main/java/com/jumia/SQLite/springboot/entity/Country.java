package com.jumia.SQLite.springboot.entity;


public class Country {
    private String phoneRegex;
    private String name;
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
/*

 */
/**
 * enum class represent the country's regex and code
 *//*

public enum CountryPhoneRegex {
    Cameroon("\\(237\\) ?[2368]\\d{7,8}$"),
    Ethiopia("\\(251\\) ?[1-59]\\d{8}$"),
    Morocco("\\(212\\) ?[5-9]\\d{8}$"),
    Mozambique("\\(258\\) ?[28]\\d{7,8}$"),
    Uganda("\\(256\\) ?\\d{9}$");

    // declaring private variable for getting values
    private final String phoneNumberRegex;

    // getter method
    public String getPhoneNumberRegex() {
        return this.phoneNumberRegex;
    }


    // enum constructor - cannot be public or protected
    private CountryPhoneRegex(String phoneNumberRegex) {
        this.phoneNumberRegex = phoneNumberRegex;
    }


}
*/
