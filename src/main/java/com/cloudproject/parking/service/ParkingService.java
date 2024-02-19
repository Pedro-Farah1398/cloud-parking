package com.cloudproject.parking.service;

import com.cloudproject.parking.entity.Parking;
import com.cloudproject.parking.exceptions.NoParkingFoundException;
import com.cloudproject.parking.repository.ParkingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
            throw new NoParkingFoundException(id);
        }
        return parking.get();
    }

    public Parking create (Parking parkingCreate) {

        parkingCreate.setId(generateUUID());
        parkingCreate.setEntryDate(LocalDateTime.now());
        return parkingDao.save(parkingCreate);
    }

    public void delete(String id) {
        Parking parking = findById(id);
        parkingDao.delete(parking);
    }

    public Parking checkOut(String id) {
        Parking parking = findById(id);
        parking.setExitDate(LocalDateTime.now());
        parking.setBill(ParkingCheckOut.getBill(parking));
        return parkingDao.save(parking);
    }

    public String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
