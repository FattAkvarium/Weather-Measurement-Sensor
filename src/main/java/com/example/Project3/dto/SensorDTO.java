package com.example.Project3.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public class SensorDTO {

    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min = 3, max = 30, message = "Name should be between 3 and 30 characters")
    private String name;

    private List<MeasurementDTO> measurementsDTO;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MeasurementDTO> getMeasurementsDTO() {
        return measurementsDTO;
    }

    public void setMeasurementsDTO(List<MeasurementDTO> measurementsDTO) {
        this.measurementsDTO = measurementsDTO;
    }
}
