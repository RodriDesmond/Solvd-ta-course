package com.rodrigocosta.models.airport;

public class Airplane {

    private String type;
    private String code;
    private Integer capacity;

    public Airplane() {
    }

    public Airplane(String type, String code, Integer capacity) {
        this.type = type;
        this.code = code;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
