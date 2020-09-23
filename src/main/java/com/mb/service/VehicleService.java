package com.mb.service;

import com.mb.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> findAll();
    Vehicle findOne(String vin);
    Vehicle create(Vehicle vehicle);
    Vehicle update(String vehin, Vehicle vehicle);
    Vehicle delete(String vehicle);

}