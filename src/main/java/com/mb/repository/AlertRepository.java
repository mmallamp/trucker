package com.mb.repository;

import com.mb.entity.Alert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlertRepository extends CrudRepository<Alert, String> {

    //Optional<Alert> findAlertBy
    Iterable<Alert> findByVin(String vin);

    Iterable<Alert> findByPriority(String priority);
}