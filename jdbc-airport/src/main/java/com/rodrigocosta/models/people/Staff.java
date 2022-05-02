package com.rodrigocosta.models.people;

import java.math.BigDecimal;

public abstract class Staff extends Person {

    private Long id;
    private BigDecimal salary;

    public Staff() {
    }

    public Staff(String firstName, String lastName, String birthDate, String phoneNumber, String address,
                 String country, Integer passport, Long id, BigDecimal salary) {
        super(firstName, lastName, birthDate, phoneNumber, address, country, passport);
        this.id = id;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
