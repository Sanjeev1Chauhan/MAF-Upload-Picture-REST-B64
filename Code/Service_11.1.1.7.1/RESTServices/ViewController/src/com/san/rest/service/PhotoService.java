package com.san.rest.service;

import com.san.rest.view.entity.PhotoEntity;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;
@Path("photos")
public class PhotoService {
    @POST
    @Path("/postImage")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postImage(@FormParam("imageData") String photoData){
        ObjectMapper mapper = new ObjectMapper();
        PhotoEntity photo = null;
        try {
            photo = mapper.readValue(photoData,PhotoEntity.class);        
            String imageData = photo.getImageDataB64();            
            String dirName="D:\\Temp\\";
            byte[] bytearray = Base64.decode(imageData);
            BufferedImage imag= ImageIO.read(new ByteArrayInputStream(bytearray));
            ImageIO.write(imag, "jpg", new File(dirName,"b.jpg"));
        } 
        catch (Exception e){
            e.printStackTrace();
            return "Error";
        }
        return "Success";
    }
}
