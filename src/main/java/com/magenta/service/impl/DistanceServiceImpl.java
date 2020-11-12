package com.magenta.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.magenta.dao.CityDAO;
import com.magenta.dao.DistanceDAO;
import com.magenta.domain.City;
import com.magenta.dto.CalculateDistanceDTO;
import com.magenta.dto.CalculationType;
import com.magenta.dto.DistanceDTO;
import com.magenta.dto.DistancesDTO;
import com.magenta.exception.DistanceNotFoundException;
import com.magenta.service.DistanceService;

@Stateless
public class DistanceServiceImpl implements DistanceService {

    private static final double EARTH_RADIUS = 6372.795;

    private final DistanceDAO distanceDAO;
    private final CityDAO cityDAO;

    @Inject
    public DistanceServiceImpl(DistanceDAO distanceDAO, CityDAO cityDAO) {
        this.distanceDAO = distanceDAO;
        this.cityDAO = cityDAO;
    }

    @Override
    public List<DistancesDTO> calculateDistance(CalculateDistanceDTO calculateDistance) throws DistanceNotFoundException {
        List<DistancesDTO> result = new ArrayList<DistancesDTO>();

        switch (calculateDistance.getCalculationType()) {
            case CROWFLIGHT:
                result.add(getCrowlightsDistance(calculateDistance));
                break;
            case DISTANCE_MATRIX:
                result.add(getDistanceMatrix(calculateDistance));
                break;
            case ALL:
                result.add(getCrowlightsDistance(calculateDistance));
                result.add(getDistanceMatrix(calculateDistance));
        }
        return result;
    }

    private DistancesDTO getDistanceMatrix(CalculateDistanceDTO calculateDistance) throws DistanceNotFoundException {
        DistancesDTO distancesDTO = new DistancesDTO(CalculationType.DISTANCE_MATRIX);

        for (Long fromCityId : calculateDistance.getFromCityIds()) {
            for (Long toCityId : calculateDistance.getToCityIds()) {
                distancesDTO.getDistance().add(new DistanceDTO(distanceDAO.getByFromCityToCity(fromCityId, toCityId)));
            }
        }

        return distancesDTO;
    }

    private DistancesDTO getCrowlightsDistance(CalculateDistanceDTO calculateDistance) {
        DistancesDTO result = new DistancesDTO(CalculationType.CROWFLIGHT);
        double sLatA = 0;
        double cLatA = 0;
        double sLatB = 0;
        double cLatB = 0;

        double delta = 0;
        double sDelta = 0;
        double cDelta = 0;

        double x = 0;
        double y = 0;

        for (City fromCity : cityDAO.getByIds(calculateDistance.getFromCityIds())) {
            for (City toCity : cityDAO.getByIds(calculateDistance.getToCityIds())) {
                sLatA = Math.sin(getRadian(fromCity.getLatitude()));
                cLatA = Math.cos(getRadian(fromCity.getLatitude()));
                sLatB = Math.sin(getRadian(toCity.getLatitude()));
                cLatB = Math.cos(getRadian(toCity.getLatitude()));

                delta = getRadian(toCity.getLongitude()) - getRadian(fromCity.getLongitude());
                sDelta = Math.sin(delta);
                cDelta = Math.cos(delta);

                x = sLatA * sLatB + cLatA * cLatB * cDelta;
                y = Math.sqrt(Math.pow(cLatB * sDelta, 2) + Math.pow(cLatA * sLatB - sLatA * cLatB * cDelta, 2));

                result.getDistance().add(
                        new DistanceDTO(
                                fromCity,
                                toCity,
                                Math.atan2(y, x) * EARTH_RADIUS)
                );
            }
        }

        return result;
    }

    private double getRadian(double coordinate) {
        return coordinate * Math.PI / 180;
    }
}
