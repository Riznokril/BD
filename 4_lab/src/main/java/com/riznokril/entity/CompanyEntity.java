package com.riznokril.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyEntity {

    private Integer id_company;
    private String year_of_foundation;
    private Integer city_id;

    public CompanyEntity(Integer id_company, String year_of_foundation, Integer city_id) {
        this.id_company = id_company;
        this.year_of_foundation = year_of_foundation;
        this.city_id = city_id;
    }

    public CompanyEntity(String year_of_foundation, Integer city_id) {
        this.year_of_foundation = year_of_foundation;
        this.city_id = city_id;
    }

    @Override
    public String toString() {
        return "\n\nCompany: id_company: " + id_company + ", year_of_foundation: " + year_of_foundation + ", " +
                "city_id: " + city_id;
    }
}
