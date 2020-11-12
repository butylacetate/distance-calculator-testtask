package com.magenta.dto;

import java.util.List;

public class CalculateDistanceDTO {

    private CalculationType calculationType;
    private List<Long> fromCityIds;
    private List<Long> toCityIds;

    public CalculateDistanceDTO() {
    }

    public CalculateDistanceDTO(CalculationType calculationType, List<Long> fromCityIds, List<Long> toCityIds) {
        this.calculationType = calculationType;
        this.fromCityIds = fromCityIds;
        this.toCityIds = toCityIds;
    }

    public CalculationType getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(CalculationType calculationType) {
        this.calculationType = calculationType;
    }

    public List<Long> getFromCityIds() {
        return fromCityIds;
    }

    public void setFromCityIds(List<Long> fromCityIds) {
        this.fromCityIds = fromCityIds;
    }

    public List<Long> getToCityIds() {
        return toCityIds;
    }

    public void setToCityIds(List<Long> toCityIds) {
        this.toCityIds = toCityIds;
    }
}
