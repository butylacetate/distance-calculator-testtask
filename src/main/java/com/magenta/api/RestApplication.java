package com.magenta.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class RestApplication extends Application {

    private Set<Class<?>> classes = new HashSet<Class<?>>();

    public RestApplication() {
        classes.add(CityApi.class);
        classes.add(CalculateDistanceApi.class);
        classes.add(UploadDataApi.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
