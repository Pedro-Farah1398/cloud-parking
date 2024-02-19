package com.cloudproject.parking.repository;

import com.cloudproject.parking.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingDao extends JpaRepository<Parking, String> {
}
