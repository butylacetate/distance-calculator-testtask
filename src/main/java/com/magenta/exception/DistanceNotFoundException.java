package com.magenta.exception;

public class DistanceNotFoundException extends Exception {

    public DistanceNotFoundException(Long fromCityId, Long toCityId) {
        super(String.format("Distance between city id=%s and id=%s not found", fromCityId, toCityId));
    }
}
