package com.magenta.service;

import com.magenta.exception.CityNotFoundException;
import com.magenta.xml.UploadData;

public interface UploadDataService {

    void saveUploadData(UploadData uploadData) throws CityNotFoundException;
}
