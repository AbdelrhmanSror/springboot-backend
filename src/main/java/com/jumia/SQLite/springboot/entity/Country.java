package com.jumia.SQLite.springboot.entity;


/**
 * enum class represent the country's regex and code
 */
public enum Country {
    Cameroon("\\(237\\) ?[2368]\\d{7,8}$"),
    Ethiopia("\\(251\\) ?[1-59]\\d{8}$"),
    Morocco("\\(212\\) ?[5-9]\\d{8}$"),
    Mozambique("\\(258\\) ?[28]\\d{7,8}$"),
    Uganda("\\(256\\) ?\\d{9}$");

    // declaring private variable for getting values
    private final String phoneNumberRegex;
    private final String countryCodeRegex;

    // getter method
    public String getPhoneNumberRegex() {
        return this.phoneNumberRegex;
    }

    public String getCountryCodeRegex() {
        return countryCodeRegex;
    }

    // enum constructor - cannot be public or protected
    private Country(String phoneNumberRegex) {
        this.phoneNumberRegex = phoneNumberRegex;
        this.countryCodeRegex = CountryCode.getCountryCodeNumberRegex(phoneNumberRegex);
    }


}
