package com.magenta.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.magenta.domain.Distance;
import com.magenta.exception.DistanceNotFoundException;

@Stateless
public class DistanceDAO {

    @PersistenceContext(unitName = "distance-calculator-unit")
    private EntityManager entityManager;

    public Distance getByFromCityToCity(Long fromCityId, Long toCityId) throws DistanceNotFoundException {
        try {
            return entityManager
                    .createQuery("select d from Distance d where d.fromCity.id = :fromCityId and d.toCity.id = :toCityId", Distance.class)
                    .setParameter("fromCityId", fromCityId)
                    .setParameter("toCityId", toCityId)
                    .getSingleResult();
        } catch (NoResultException e) {
            throw new DistanceNotFoundException(fromCityId, toCityId);
        }
    }

    public void save(Distance distance) {
        entityManager.persist(distance);
        entityManager.flush();
    }
}
