package com.magenta.service;

import java.util.List;

import com.magenta.dto.CalculateDistanceDTO;
import com.magenta.dto.DistancesDTO;
import com.magenta.exception.DistanceNotFoundException;

public interface DistanceService {

    List<DistancesDTO> calculateDistance(CalculateDistanceDTO calculateDistance) throws DistanceNotFoundException;
}
