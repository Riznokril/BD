package com.riznokril.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelEntity {

    private Integer id_model;
    private String name;
    private String max_speed;
    private Integer passenger_capacity;
    private String width;
    private String length;
    private String height;

    public ModelEntity(Integer id_model, String name, String max_speed, Integer passenger_capacity,
                       String width, String length, String height) {
        this.id_model = id_model;
        this.name = name;
        this.max_speed = max_speed;
        this.passenger_capacity = passenger_capacity;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public ModelEntity(String name, String max_speed, Integer passenger_capacity,
                       String width, String length, String height) {
        this.name = name;
        this.max_speed = max_speed;
        this.passenger_capacity = passenger_capacity;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    @Override
    public String toString() {
        return "\n\nModel: id_model: " + id_model + ", name: " + name + ", " +
                "max_speed: " + max_speed + ", passenger_capacity: " + passenger_capacity
                + ", width: " + width + ", length:" + length + ", height:" + height;
    }
}

