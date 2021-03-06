package com.mb.repository;

import com.mb.entity.Reading;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingRepository extends CrudRepository<Reading, String> {

}
