package com.internship.firstbackend.dbconnector;



import com.google.gson.Gson;
import com.internship.firstbackend.model.Plane;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.print.Doc;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MongoConnector {

    private MongoDatabase database;
    private final ConnectionString mongoUrl = new ConnectionString("mongodb://user1:Password.12345@cluster0-shard-00-00.gxrol.mongodb.net:27017,cluster0-shard-00-01.gxrol.mongodb.net:27017,cluster0-shard-00-02.gxrol.mongodb.net:27017/flightDB?ssl=true&replicaSet=atlas-bkrq6u-shard-0&authSource=admin&retryWrites=true&w=majority");

    public MongoConnector(){


        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(mongoUrl)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("flightDB");

        /*
        MongoCollection<Document> collection = database.getCollection("planes");

        List<Document> planes = collection.find().into(new ArrayList<>());
        System.out.println("Plane list with an ArrayList:");
        for (Document plane : planes) {
            Gson gson = new Gson(); // Or use new GsonBuilder().create();
            Plane mongoPlane = gson.fromJson(plane.toJson(), Plane.class); // deserializes json into target2
            //System.out.println(plane.toJson());
            System.out.println(mongoPlane.toString());
        }
        */


        //Document plane1 = collection.find().first();
        //System.out.println("plane 1: " + plane1.toJson());

    }

    public ArrayList<Plane> getPlanes(){
        ArrayList<Plane> planeList = new ArrayList<>();
        MongoCollection<Document> collection = database.getCollection("planes");
        List<Document> planes = collection.find().into(new ArrayList<>());
        System.out.println("Plane list with an ArrayList:");
        for (Document plane : planes) {
            Gson gson = new Gson(); // Or use new GsonBuilder().create();
            Plane mongoPlane = gson.fromJson(plane.toJson(), Plane.class); // deserializes json into target2
            planeList.add(mongoPlane);
            System.out.println(mongoPlane.toString());
        }
        return planeList;
    }

    private Plane getPlaneById(String requestedPlaneId){
        MongoCollection<Document> collection = database.getCollection("planes");
        List<Document> planes = collection.find().into(new ArrayList<>());
        System.out.println("Plane list with an ArrayList:");
        for (Document plane : planes) {
            Gson gson = new Gson(); // Or use new GsonBuilder().create();
            Plane mongoPlane = gson.fromJson(plane.toJson(), Plane.class); // deserializes json into target2
            if(mongoPlane.getPlaneId().equals(requestedPlaneId)){
                System.out.println(mongoPlane.toString());
                return mongoPlane;
            }
        }
        return null;
    }

    private void addPlane(){

    }













    private void connect(){

    }

    private void printResults(List<Document> documents){

    }





}
