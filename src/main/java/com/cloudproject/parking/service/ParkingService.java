package com.cloudproject.parking.service;

import com.cloudproject.parking.entity.Parking;
import com.cloudproject.parking.exceptions.NoParkingFoundException;
import com.cloudproject.parking.repository.ParkingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingService {

    @Autowired
    private ParkingDao parkingDao;

    public List<Parking> findAll() {
        return parkingDao.findAll();
    }

    public Parking findById(String id) {
        Optional<Parking> parking = parkingDao.findById(id);
        if (parking.isEmpty()) {
            throw new NoParkingFoundException();
        }
        return parking.get();
    }

    public void create () {

    }

    public String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
