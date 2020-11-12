package com.magenta.exception;

public class CityNotFoundException extends Exception {

    public CityNotFoundException(String name) {
        super(String.format("City with name = %s not found", name));
    }
}
