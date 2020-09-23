package com.mb.service;

import com.mb.entity.Reading;

import java.util.List;

public interface ReadingService {

    List<Reading> findAll();

    Reading findOne(String id);

    Reading create(Reading reading);

}
