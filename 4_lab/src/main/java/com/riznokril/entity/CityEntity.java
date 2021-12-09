package com.riznokril.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityEntity {

    private Integer id_city;
    private String name;
    private String country;
    private String post_number;
    private String year_of_foundation;

    public CityEntity(Integer id_city, String name, String country, String post_number, String year_of_foundation) {
        this.id_city = id_city;
        this.name = name;
        this.country = country;
        this.post_number = post_number;
        this.year_of_foundation = year_of_foundation;
    }

    public CityEntity(String name, String country, String post_number, String year_of_foundation) {
        this.name = name;
        this.country = country;
        this.post_number = post_number;
        this.year_of_foundation = year_of_foundation;
    }

    @Override
    public String toString() {
        return "\n\nCity: id_city: " + id_city + ", name: " + name + ", " +
                "country: " + country + ", post_number: " + post_number + ", year_of_foundation: " + year_of_foundation;
    }
}
