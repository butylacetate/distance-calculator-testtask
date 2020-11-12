package com.magenta.dto;

import com.magenta.domain.City;
import com.magenta.domain.Distance;

public class DistanceDTO {

    private City fromCity;
    private City toCity;
    private Double distance;

    public DistanceDTO(City fromCity, City toCity, Double distance) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
    }

    public DistanceDTO(Distance distance) {
        this.fromCity = distance.getFromCity();
        this.toCity = distance.getToCity();
        this.distance = distance.getDistance();
    }

    public City getFromCity() {
        return fromCity;
    }

    public void setFromCity(City fromCity) {
        this.fromCity = fromCity;
    }

    public City getToCity() {
        return toCity;
    }

    public void setToCity(City toCity) {
        this.toCity = toCity;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
