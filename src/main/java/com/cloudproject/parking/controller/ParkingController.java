package com.cloudproject.parking.controller;

import com.cloudproject.parking.controller.dto.ParkingDTO;
import com.cloudproject.parking.controller.mapper.ParkingMapper;
import com.cloudproject.parking.entity.Parking;
import com.cloudproject.parking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    private ParkingService service;

    @Autowired
    private ParkingMapper mapper;

    @GetMapping("/findAll")
    public List<ParkingDTO> findAll() {
        List<Parking> parkings =  service.findAll();
        return mapper.toParkingDTOList(parkings);
    }
}
