package com.jumia.SQLite.springboot.entity;

import java.util.HashMap;

/**
 * Cameroon("\\(237\\) ?[2368]\\d{7,8}$"),
 * Ethiopia("\\(251\\) ?[1-59]\\d{8}$"),
 * Morocco("\\(212\\) ?[5-9]\\d{8}$"),
 * Mozambique("\\(258\\) ?[28]\\d{7,8}$"),
 * Uganda("\\(256\\) ?\\d{9}$");
 */
public class CountryCode {
    public static final String CAMEROON_CODE = "237";
    public static final String ETHIOPIA_CODE = "251";
    public static final String MOROCCO_CODE = "212";
    public static final String MOZAMBIQUE_CODE = "258";
    public static final String UGANDA_CODE = "256";

    public static final String Cameroon = "CAMEROON";
    public static final String Ethiopia = "ETHIOPIA";
    public static final String Morocco = "MOROCCO";
    public static final String Mozambique = "MOZAMBIQUE";
    public static final String Uganda = "UGANDA";


    public static final String CAMEROON_REGEX = "\\(237\\) ?[2368]\\d{7,8}$";
    public static final String ETHIOPIA_REGEX = "\\(251\\) ?[1-59]\\d{8}$";
    public static final String MOROCCO_REGEX = "\\(212\\) ?[5-9]\\d{8}$";
    public static final String MOZAMBIQUE_REGEX = "\\(258\\) ?[28]\\d{7,8}$";
    public static final String UGANDA_REGEX = "\\(256\\) ?\\d{9}$";


    private static final HashMap<String, Country> countryCodeToCountry = new HashMap<>() {{
        put(CAMEROON_CODE, new Country(Cameroon, CAMEROON_REGEX));
        put(ETHIOPIA_CODE, new Country(Ethiopia, ETHIOPIA_REGEX));
        put(MOROCCO_CODE, new Country(Morocco, MOROCCO_REGEX));
        put(MOZAMBIQUE_CODE, new Country(Mozambique, MOZAMBIQUE_REGEX));
        put(UGANDA_CODE, new Country(Uganda, UGANDA_REGEX));
    }};


    public static Boolean isExist(String countryCode) {
        return countryCodeToCountry.containsKey(countryCode);
    }

    public static Boolean isNotExist(String countryCode) {
        return !countryCodeToCountry.containsKey(countryCode);
    }

    public static Country getCountry(String countryCode) {
        return countryCodeToCountry.getOrDefault(countryCode, null);
    }


}
