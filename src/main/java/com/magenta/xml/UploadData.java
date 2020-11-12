package com.magenta.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="UploadData")
@XmlAccessorType(XmlAccessType.FIELD)
public class UploadData {

    @XmlElementWrapper(name="Cities")
    @XmlElement(name="City")
    private List<CityData> cities;
    @XmlElementWrapper(name="Distances")
    @XmlElement(name="Distance")
    private List<DistanceData> distances;

    public UploadData() {
    }

    public UploadData(List<CityData> cities, List<DistanceData> distances) {
        this.cities = cities;
        this.distances = distances;
    }

    public List<CityData> getCities() {
        return cities;
    }

    public void setCities(List<CityData> cities) {
        this.cities = cities;
    }

    public List<DistanceData> getDistances() {
        return distances;
    }

    public void setDistances(List<DistanceData> distances) {
        this.distances = distances;
    }
}
