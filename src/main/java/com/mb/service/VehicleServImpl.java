package com.mb.service;

import com.mb.entity.Vehicle;
import com.mb.exception.VehicleNotFoundException;
import com.mb.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServImpl implements VehicleService
{
    @Autowired
    VehicleRepository repository;

    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return (List<Vehicle>) repository.findAll();
    }

    @Transactional(readOnly=true)
    public Vehicle findOne(String vin) {
        Optional<Vehicle> existing = repository.findByVin(vin);
        if(!existing.isPresent())
        {
            throw new VehicleNotFoundException("Vehicle with id = " +vin+ "Not found");
        }
        else
        {
            return existing.get();
        }
    }

    @Transactional
    public Vehicle create(Vehicle vehicle)
    {
        return repository.save(vehicle);
    }

    @Transactional
    public Vehicle update(String vin, Vehicle vehicle) {
        Optional<Vehicle> existing = repository.findByVin(vin);
        if(!existing.isPresent())
        {
            throw new VehicleNotFoundException("Vehicle with id = " +vin+ "Not found");
        }
        else
        {
            return repository.save(vehicle);
        }
    }

    @Transactional
    public Vehicle delete(String vin) {
        Optional<Vehicle> existing = repository.findById(vin);
        if(!existing.isPresent())
        {
            throw new VehicleNotFoundException("Vehicle with id = " +vin+ "Not found");
        }
        repository.delete(existing.get());

        return null;
    }

}

