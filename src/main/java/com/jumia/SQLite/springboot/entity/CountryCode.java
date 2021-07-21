package com.jumia.SQLite.springboot.entity;

import java.util.HashMap;

public class CountryCode {
    private static final HashMap<String, Country> countryCodeToPhoneRegex = new HashMap<String, Country>() {{
        put("237", Country.Cameroon);
        put("251", Country.Ethiopia);
        put("212", Country.Morocco);
        put("258", Country.Mozambique);
        put("256", Country.Uganda);
    }};


    public static Country getCountry(String countryCode) {
        return countryCodeToPhoneRegex.getOrDefault(countryCode, null);
    }
}
