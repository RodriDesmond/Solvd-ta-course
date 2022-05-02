package com.rodrigocosta.models.enums;

public enum Airportcode {
    SCL("Santiago"),
    ORL("Orlando"),
    JFK("John F Kennedy"),
    LHR("London Heathrow"),
    CDG("Charles De Gaulle"),
    LAX("Los Angeles"),
    BOS("Boston"),
    LAS("Las Vegas"),
    MEX("Mexico City"),
    MCO("Orlando"),
    MSP("Minneapolis"),
    ORD("Chicago"),
    PHL("Philadelphia"),
    PHX("Phoenix"),
    SEA("Seattle"),
    SFO("San Francisco"),
    SJC("San Jose"),
    TPA("Tampa"),
    YVR("Vancouver"),
    YYZ("Toronto");

    private final String airportName;

    Airportcode(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportName() {
        return airportName;
    }
}
