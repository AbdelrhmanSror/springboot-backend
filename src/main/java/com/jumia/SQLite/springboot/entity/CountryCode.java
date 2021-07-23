package com.jumia.SQLite.springboot.entity;

import java.util.HashMap;

public class CountryCode {
    private static final String CAMEROON = "237";
    private static final String ETHIOPIA = "251";
    private static final String MOROCCO = "212";
    private static final String MOZAMBIQUE = "258";
    private static final String UGANDA = "256";

    private static final HashMap<String, Country> countryCodeToPhoneRegex = new HashMap<String, Country>() {{
        put(CAMEROON, Country.Cameroon);
        put(ETHIOPIA, Country.Ethiopia);
        put(MOROCCO, Country.Morocco);
        put(MOZAMBIQUE, Country.Mozambique);
        put(UGANDA, Country.Uganda);
    }};


    public static Country getCountry(String countryCode) {
        return countryCodeToPhoneRegex.getOrDefault(countryCode, null);
    }

    public static String getCountryCodeNumber(String phoneNumber) {
        try {
            return phoneNumber.substring(1, 4);
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }
    public static String getCountryCodeNumberRegex(String phoneNumberRegex) {
        try {
            return phoneNumberRegex.substring(2, 5);
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }
}
