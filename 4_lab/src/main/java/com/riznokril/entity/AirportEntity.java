package com.riznokril.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirportEntity {

    private Integer id_airport;
    private String name;
    private Integer city_id;

    public AirportEntity(Integer id_airport, String name, Integer city_id) {
        this.id_airport = id_airport;
        this.name = name;
        this.city_id = city_id;
    }

    @Override
    public String toString() {
        return "\n\nAirport: id_airport: " + id_airport + ", name: " + name + ", " +
                "city_id: " + city_id;
    }
}
