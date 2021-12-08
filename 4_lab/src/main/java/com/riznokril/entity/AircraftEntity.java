package com.riznokril.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class AircraftEntity {

    private Integer id_aircraft;
    private Integer id_company;
    private Date expiration_date;
    private Date date_of_commissioning;
    private Integer model_id;

    public AircraftEntity(Integer id_aircraft, Integer id_company, Date expiration_date, Date data_of_commissioning,
                         Integer model_id) {
        this.id_aircraft = id_aircraft;
        this.id_company = id_company;
        this.expiration_date = expiration_date;
        this.date_of_commissioning = data_of_commissioning;
        this.model_id = model_id;
    }

    @Override
    public String toString() {
        return "\n\nModel: id_aircraft: " + id_aircraft + ", id_company: " + id_company + ", " +
                "expiration_date: " + expiration_date + ", data_of_commissioning: " + date_of_commissioning
                + ", model_id: " + model_id;
    }
}
