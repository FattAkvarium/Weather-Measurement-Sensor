package com.example.Project3.utils;

import com.example.Project3.models.Measurement;
import com.example.Project3.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MeasurementValidator implements Validator {
    private final SensorService sensorService;

    @Autowired
    public MeasurementValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Measurement.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Measurement measurement = (Measurement) target;

        if(measurement.getSensor() == null) {
            return;
        }

        if(sensorService.getSensorByName(measurement.getSensor().getName()).isEmpty()) {
            errors.rejectValue("sensor", "Сенсора с таким названием не существует");
        }
    }
}
