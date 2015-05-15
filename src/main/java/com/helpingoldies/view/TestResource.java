package com.helpingoldies.view;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/tests")
public class TestResource {

    @GET
    public String getHelloWorld(){
        MongoClient mongoClient = new MongoClient("db");

        MongoDatabase database = mongoClient.getDatabase("domygroceriesdb");
        MongoCollection<Document> testCollection = database.getCollection("test");
        
        return testCollection.find().first().toJson();
    }

}
