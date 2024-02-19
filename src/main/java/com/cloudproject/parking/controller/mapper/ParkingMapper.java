package com.cloudproject.parking.controller.mapper;

import com.cloudproject.parking.controller.dto.ParkingDTO;
import com.cloudproject.parking.entity.Parking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper {

    private static final ModelMapper mapper = new ModelMapper();

    public ParkingDTO toParkingDTO(Parking parking) {
        return mapper.map(parking, ParkingDTO.class);
    }

    public List<ParkingDTO> toParkingDTOList(List<Parking> parkingList) {
    return parkingList.stream().map(this::toParkingDTO).collect(Collectors.toList());
    }
}
