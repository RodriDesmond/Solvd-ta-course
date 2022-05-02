package com.rodrigocosta.models.people;

import java.math.BigDecimal;

public class Pilot extends  Staff {

    private String licence;

    public Pilot(String firstName, String lastName, String birthDate, String phoneNumber, String address,
                 String country, Integer passport, Long id, BigDecimal salary, String licence) {
        super(firstName, lastName, birthDate, phoneNumber, address, country, passport, id, salary);
        this.licence = licence;
    }
}
