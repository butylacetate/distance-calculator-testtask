package com.magenta.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DistanceData {

    @XmlElement(name="FromCityName")
    private String fromCityName;
    @XmlElement(name="ToCityName")
    private String toCityName;
    @XmlElement(name="Distance")
    private Double distance;

    public DistanceData() {
    }

    public DistanceData(String fromCityName, String toCityName, Double distance) {
        this.fromCityName = fromCityName;
        this.toCityName = toCityName;
        this.distance = distance;
    }

    public String getFromCityName() {
        return fromCityName;
    }

    public void setFromCityName(String fromCityName) {
        this.fromCityName = fromCityName;
    }

    public String getToCityName() {
        return toCityName;
    }

    public void setToCityName(String toCityName) {
        this.toCityName = toCityName;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
