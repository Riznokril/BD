package com.riznokril.entity;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightsEntity {

    private Integer flight_number;
    private Integer aircraft_id;
    private Timestamp departure_time;
    private Timestamp arrival_time;
    private Integer arrival_airport_id;
    private Integer departure_airport_id;

    public FlightsEntity(Integer flight_number, Integer aircraft_id, Timestamp departure_time, Timestamp arrival_time,
                         Integer arrival_airport_id, Integer departure_airport_id) {
        this.flight_number = flight_number;
        this.aircraft_id = aircraft_id;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.arrival_airport_id = arrival_airport_id;
        this.departure_airport_id = departure_airport_id;
    }

    @Override
    public String toString() {
        return "\n\nFlight: flight_number: " + flight_number + ", aircraft_id: " + aircraft_id + ", " +
                "departure_time: " + departure_time + ", arrival_time: " + arrival_time
                + ", arrival_airport_id: " + arrival_airport_id + ", departure_airport_id: " + departure_airport_id;
    }
}