package com.example.Project3.dto;

import com.example.Project3.models.Sensor;
import jakarta.validation.constraints.*;

import java.util.Date;

public class MeasurementDTO {

    @NotNull
    @Min(-100)
    @Max(100)
    private Double value;

    @NotNull
    private Boolean raining;

    private Date measurementDateTime;

    @NotNull
    private Sensor sensor;


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Date getMeasurementDateTime() {
        return measurementDateTime;
    }

    public void setMeasurementDateTime(Date measurementDateTime) {
        this.measurementDateTime = measurementDateTime;
    }
}
