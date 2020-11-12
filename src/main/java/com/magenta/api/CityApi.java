package com.magenta.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.magenta.service.CityService;

@Path("/city")
public class CityApi {

    @Inject
    private CityService cityService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCities() {
        return Response.ok().entity(cityService.getAll()).build();
    }
}
