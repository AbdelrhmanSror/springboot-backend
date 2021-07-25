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
    private static final String CAMEROON = "237";
    private static final String ETHIOPIA = "251";
    private static final String MOROCCO = "212";
    private static final String MOZAMBIQUE = "258";
    private static final String UGANDA = "256";
    private static final String CAMEROON_REGEX = "\\(237\\) ?[2368]\\d{7,8}$";
    private static final String ETHIOPIA_REGEX = "\\(251\\) ?[1-59]\\d{8}$";
    private static final String MOROCCO_REGEX = "\\(212\\) ?[5-9]\\d{8}$";
    private static final String MOZAMBIQUE_REGEX = "\\(258\\) ?[28]\\d{7,8}$";
    private static final String UGANDA_REGEX = "\\(256\\) ?\\d{9}$";


    private static final HashMap<String, Country> countryCodeToCountry = new HashMap<>() {{
        put(CAMEROON, new Country("CAMEROON", CAMEROON_REGEX));
        put(ETHIOPIA, new Country("ETHIOPIA", ETHIOPIA_REGEX));
        put(MOROCCO, new Country("MOROCCO", MOROCCO_REGEX));
        put(MOZAMBIQUE, new Country("MOZAMBIQUE", MOZAMBIQUE_REGEX));
        put(UGANDA, new Country("UGANDA", UGANDA_REGEX));
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
