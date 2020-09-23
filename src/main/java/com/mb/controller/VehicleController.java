package com.mb.controller;

import com.mb.entity.Vehicle;
import com.mb.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    VehicleService service;

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehicle> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Vehicle findOne(@PathVariable("vin") String vehin)
    {
        return service.findOne(vehin);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Vehicle create(@RequestBody Vehicle vehicle)
    {
        return service.create(vehicle);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{vin}",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Vehicle update(@PathVariable("vin") String vehin,@RequestBody Vehicle vehicle)
    {
        return service.update(vehin,vehicle);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{vin}")
    public Vehicle delete(@PathVariable("vin") String vehin)
    {
        return service.delete(vehin);
    }
}

