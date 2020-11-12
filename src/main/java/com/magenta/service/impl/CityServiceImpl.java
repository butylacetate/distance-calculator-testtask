package com.magenta.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.magenta.dao.CityDAO;
import com.magenta.domain.City;
import com.magenta.service.CityService;

@Stateless
public class CityServiceImpl implements CityService {

    @Inject
    private CityDAO cityDAO;

    @Override
    public List<City> getAll() {
        return cityDAO.getAll();
    }
}
