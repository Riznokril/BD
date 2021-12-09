package com.riznokril.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class AircraftEntity {

    private Integer id_aircraft;
    private Integer company_id;
    private Date expiration_date;
    private Date date_of_commissioning;
    private Integer model_id;

    public AircraftEntity(Integer id_aircraft, Integer company_id, Date expiration_date, Date data_of_commissioning,
                         Integer model_id) {
        this.id_aircraft = id_aircraft;
        this.company_id = company_id;
        this.expiration_date = expiration_date;
        this.date_of_commissioning = data_of_commissioning;
        this.model_id = model_id;
    }

    public AircraftEntity(Integer company_id, Date expiration_date, Date data_of_commissioning,
                          Integer model_id) {
        this.company_id = company_id;
        this.expiration_date = expiration_date;
        this.date_of_commissioning = data_of_commissioning;
        this.model_id = model_id;
    }

    @Override
    public String toString() {
        return "\n\nAircraft: id_aircraft: " + id_aircraft + ", company_id: " + company_id + ", " +
                "expiration_date: " + expiration_date + ", data_of_commissioning: " + date_of_commissioning
                + ", model_id: " + model_id;
    }
}
