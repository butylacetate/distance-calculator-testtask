package com.magenta.dto;

import java.util.LinkedList;
import java.util.List;

public class DistancesDTO {

    private CalculationType type;
    private List<DistanceDTO> distance;

    public DistancesDTO(CalculationType type) {
        this.type = type;
        this.distance = new LinkedList<DistanceDTO>();
    }

    public DistancesDTO(CalculationType type, List<DistanceDTO> distance) {
        this.type = type;
        this.distance = distance;
    }

    public CalculationType getType() {
        return type;
    }

    public void setType(CalculationType type) {
        this.type = type;
    }

    public List<DistanceDTO> getDistance() {
        return distance;
    }

    public void setDistance(List<DistanceDTO> distance) {
        this.distance = distance;
    }
}
