package com.rodrigocosta.models.people;

import java.math.BigDecimal;

public class Attendant extends Staff {

    public Attendant() {
    }

    public Attendant(String firstName, String lastName, String birthDate, String phoneNumber, String address,
                           String country, Integer passport, Long id, BigDecimal salary) {
        super(firstName, lastName, birthDate, phoneNumber, address, country, passport, id, salary);
    }
}
