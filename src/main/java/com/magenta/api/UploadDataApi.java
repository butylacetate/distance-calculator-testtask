package com.magenta.api;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import com.magenta.exception.CityNotFoundException;
import com.magenta.service.UploadDataService;
import com.magenta.xml.UploadData;

@Path("/upload")
public class UploadDataApi {

    @Inject
    private UploadDataService uploadDataService;

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(MultipartFormDataInput input) {
        List<InputPart> parts = input.getFormDataMap().get("file");

        if (parts != null && !parts.isEmpty()) {
            try {
                JAXBContext jc = JAXBContext.newInstance(UploadData.class);
                UploadData uploadData = (UploadData) jc.createUnmarshaller().unmarshal(parts.get(0).getBody(InputStream.class, null));
                uploadDataService.saveUploadData(uploadData);
            } catch (IOException | JAXBException | CityNotFoundException e) {
                return Response.serverError().build();
            }
        }
        return Response.ok().build();
    }
}
