package com.riznokril.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PilotEntity {

    private Integer id_pilot;
    private Integer company_id;
    private Integer aircraft_id;
    private String name;
    private String licence_number;
    private String surname;
    private String year_of_employment;

    public PilotEntity(Integer id_pilot, Integer aircraft_id, Integer company_id,String name, String licence_number,
                       String surname, String year_of_employment) {
        this.id_pilot = id_pilot;
        this.aircraft_id = aircraft_id;
        this.company_id = company_id;
        this.name = name;
        this.licence_number = licence_number;
        this.surname = surname;
        this.year_of_employment = year_of_employment;
    }

    @Override
    public String toString() {
        return "\n\nPilot: id_pilot: " + id_pilot + ", aircraft_id" + aircraft_id + ", company_id: " + company_id + ", " +
                "name: " + name + ", licence_number: " + licence_number
                + ", surname: " + surname + ", year_of_employment:" + year_of_employment;
    }
}
