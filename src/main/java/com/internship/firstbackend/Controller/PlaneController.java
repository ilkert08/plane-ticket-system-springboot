package com.internship.firstbackend.Controller;

import com.internship.firstbackend.dbconnector.MongoConnector;
import com.internship.firstbackend.model.datamodels.Plane;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PlaneController {

    private ArrayList<Plane> planeList;
    private MongoConnector mongoConnection;

    public PlaneController(){
        planeList = new ArrayList<Plane>();
        mongoConnection = MongoConnector.Singleton();
    }

    @GetMapping("/planetest")
    public String planeTest(){
        planeList = mongoConnection.getPlanes();
        return mongoConnection.toString();
    }


    @GetMapping("/planes")
    public ArrayList<Plane> getAllPlanes(){
        planeList = mongoConnection.getPlanes();
        return planeList;
    }

    @GetMapping("/plane")
    public Plane getPlaneById(@RequestParam(value = "id", defaultValue = "id1") String requestedPlaneId){
        Plane requestedPlane = mongoConnection.getPlaneById(requestedPlaneId);

        if(requestedPlane != null){
            return requestedPlane;
        }

        //TODO Hata mesajı bastırmak için ne yapmalıyım? Sor.
        //JSONObject json = new JSONObject();
        //json.put("ErrorMessage", "Plane is not in database.");

        return null;
    }





    @PostMapping("/newplane")
    public Plane addPlane(@RequestBody Plane newPlane){
        mongoConnection.addPlane(newPlane);
        return newPlane;
    }



}
