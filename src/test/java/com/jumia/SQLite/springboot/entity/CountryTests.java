package com.jumia.SQLite.springboot.entity;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CountryTests {
    String name=CountryCode.Cameroon;
    String codeRegex=CountryCode.CAMEROON_CODE;
    String phoneRegex=CountryCode.CAMEROON_REGEX;
    private Country country=new Country(name,phoneRegex);

    @Test
    public void getName() {
        Assertions.assertThat(country.getName()).isEqualTo(name);
        System.out.println(country.getName());
    }

    @Test
    public void getCodeRegex() {
        Assertions.assertThat(country.getCodeRegex()).isEqualTo(codeRegex);
        System.out.println(country.getCodeRegex());
    }
    @Test
    public void getPhoneRegex() {
        Assertions.assertThat(country.getPhoneRegex()).isEqualTo(phoneRegex);
        System.out.println(country.getPhoneRegex());
    }
}
