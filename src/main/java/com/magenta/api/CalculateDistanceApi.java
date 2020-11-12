package com.magenta.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.magenta.dto.CalculateDistanceDTO;
import com.magenta.exception.DistanceNotFoundException;
import com.magenta.service.DistanceService;

@Path("/calculate-distance")
public class CalculateDistanceApi {

    @Inject
    private DistanceService distanceService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response calculateDistance(CalculateDistanceDTO calculateDistance) {
        try {
            return Response.ok(distanceService.calculateDistance(calculateDistance)).build();
        } catch (DistanceNotFoundException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
