package com.example.Project3.repositories;

import com.example.Project3.models.Measurement;
import com.example.Project3.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {

}
