package com.magenta.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.magenta.dao.CityDAO;
import com.magenta.dao.DistanceDAO;
import com.magenta.domain.City;
import com.magenta.domain.Distance;
import com.magenta.exception.CityNotFoundException;
import com.magenta.service.UploadDataService;
import com.magenta.xml.CityData;
import com.magenta.xml.DistanceData;
import com.magenta.xml.UploadData;

@Stateless
public class UploadDataServiceImpl implements UploadDataService {

    private final CityDAO cityDAO;
    private final DistanceDAO distanceDAO;

    @Inject
    public UploadDataServiceImpl(CityDAO cityDAO, DistanceDAO distanceDAO) {
        this.cityDAO = cityDAO;
        this.distanceDAO = distanceDAO;
    }

    @Override
    public void saveUploadData(UploadData uploadData) throws CityNotFoundException {
        for (CityData cityData : uploadData.getCities()) {
            cityDAO.save(new City(cityData));
        }

        for (DistanceData distanceData : uploadData.getDistances()) {
            distanceDAO.save(new Distance(
                    cityDAO.getByName(distanceData.getFromCityName()),
                    cityDAO.getByName(distanceData.getToCityName()),
                    distanceData.getDistance()));
        }
    }
}
