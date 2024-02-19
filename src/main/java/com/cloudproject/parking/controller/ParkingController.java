package com.cloudproject.parking.controller;

import com.cloudproject.parking.controller.dto.ParkingCreateDTO;
import com.cloudproject.parking.controller.dto.ParkingDTO;
import com.cloudproject.parking.controller.mapper.ParkingMapper;
import com.cloudproject.parking.entity.Parking;
import com.cloudproject.parking.service.ParkingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@Api(tags = "Parkings Controller")
public class ParkingController {

    @Autowired
    private ParkingService service;

    @Autowired
    private ParkingMapper mapper;

    @GetMapping("/findAll")
    @ApiOperation("Find All Parkings")
    public ResponseEntity<List<ParkingDTO>> findAll() {
        List<Parking> parkings =  service.findAll();
        List<ParkingDTO> result =  mapper.toParkingDTOList(parkings);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @ApiOperation("Find Parking by Id")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id) {
        Parking parking = service.findById(id);
        ParkingDTO result = mapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/create")
    @ApiOperation("Create new Parking")
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto) {
        Parking parking = mapper.toParking(dto);
        Parking created = service.create(parking);
        ParkingDTO result = mapper.toParkingDTO(created);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete Parking")
    public ResponseEntity delete (@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
