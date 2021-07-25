package com.jumia.SQLite.springboot.models;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CountryCodeTests {
    String code = CountryCode.CAMEROON_CODE;

    @Test
    public void isExist() {
        System.out.println(CountryCode.isExist(code));
    }

    @Test
    public void isNotExist() {
        System.out.println(CountryCode.isNotExist(code));
    }

    @Test
    public void getCountry() {
        System.out.println(CountryCode.getCountry(code));
    }


}
