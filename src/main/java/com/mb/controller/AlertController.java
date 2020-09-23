package com.mb.controller;

import com.mb.entity.Alert;
import com.mb.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertController {
    @Autowired
    AlertService alertService;

    @GetMapping(path = "/vin/{vin}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Alert> findAlerts(@PathVariable String vin) {
        return alertService.findAlertsByVin(vin);
    }

    @GetMapping(path = "/priority/{priority_type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Alert> findAlertsByPriority(@PathVariable String priority_type) {
        return alertService.findAlertsByPriority(priority_type);
    }
}