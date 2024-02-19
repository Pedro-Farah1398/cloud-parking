package com.cloudproject.parking.controller.dto;

import lombok.Data;

@Data
public class ParkingCreateDTO {

    private String license;
    private String model;
    private String color;
}
