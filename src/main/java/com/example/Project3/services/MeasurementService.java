package com.example.Project3.services;


import com.example.Project3.models.Measurement;
import com.example.Project3.repositories.MeasurementRepository;
import com.example.Project3.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    private final SensorRepository sensorRepository;


    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, SensorRepository sensorRepository) {
        this.measurementRepository = measurementRepository;
        this.sensorRepository = sensorRepository;
    }

    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    @Transactional
    public void save(Measurement measurement) {
        enrichMeasurement(measurement);
        measurement.setMeasurementDateTime(new Date());
        measurementRepository.save(measurement);
    }

    public int daysWithRain() {
        List<Measurement> count =
                measurementRepository.findAll().stream().filter(Measurement::isRaining).toList();
        return count.size();
    }

    private void enrichMeasurement(Measurement measurement) {
        measurement.setSensor(sensorRepository.findByName(measurement.getSensor().getName()).get());
//        measurement.setMeasurementDateTime(LocalDateTime.now());
    }
}
