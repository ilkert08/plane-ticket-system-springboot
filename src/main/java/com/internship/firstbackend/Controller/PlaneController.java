package com.internship.firstbackend.Controller;

import com.internship.firstbackend.dbconnector.MongoConnector;
import com.internship.firstbackend.model.Plane;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PlaneController {

    private ArrayList<Plane> planeList;

    public PlaneController(){
        planeList = new ArrayList<Plane>();
        Plane plane1 = new Plane("id1", 100, "Boeing", "E5000", 300.5F);
        Plane plane2 = new Plane("id2", 100, "Boeing", "E5000", 300.5F);
        Plane plane3 = new Plane("id3", 100, "Boeing", "E5000", 300.5F);

        //planeList.add(plane1);
        //planeList.add(plane2);
        //planeList.add(plane3);
    }


    @GetMapping("/planes")
    public ArrayList<Plane> getAllPlanes(){
        MongoConnector mongoConnection = new MongoConnector();
        planeList = mongoConnection.getPlanes();
        return planeList;
    }

    @GetMapping("/plane")
    public Plane getPlaneById(@RequestParam(value = "id", defaultValue = "id1") String requestedPlaneId){
        MongoConnector mongoConnection = new MongoConnector();
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
        MongoConnector mongoConnection = new MongoConnector();
        mongoConnection.addPlane(newPlane);
        return newPlane;
    }



}
