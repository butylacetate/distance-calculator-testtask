package com.magenta.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.magenta.domain.City;
import com.magenta.exception.CityNotFoundException;

@Stateless
public class CityDAO {

    @PersistenceContext(unitName = "distance-calculator-unit")
    private EntityManager entityManager;

    public List<City> getAll() {
        return entityManager.createQuery("SELECT c from City c", City.class).getResultList();
    }

    public List<City> getByIds(List<Long> cityIds) {
        return entityManager
                .createQuery("select c from City c where c.id in (:ids)", City.class)
                .setParameter("ids", cityIds)
                .getResultList();
    }

    public City getByName(String name) throws CityNotFoundException {
        try {
            return entityManager.createQuery("select c from City c where c.name = :name", City.class)
                    .setParameter("name", name).getSingleResult();
        } catch (NoResultException e) {
            throw new CityNotFoundException(name);
        }
    }

    public void save(City city) {
        entityManager.persist(city);
        entityManager.flush();
    }

}
