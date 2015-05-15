package com.helpingoldies.infrastructure;


import com.helpingoldies.view.TestResource;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.bson.Document;


public class DoMyGroceriesApplication extends Application<DoMyGroceriesConfiguration> {

    public static void main(String[] args) throws Exception {
        new DoMyGroceriesApplication().run(args);
    }

    @Override
    public String getName() {
        return "do-my-groceries";
    }

    @Override
    public void run(DoMyGroceriesConfiguration configuration, Environment environment) throws Exception {
        final TestResource resource = new TestResource();
        environment.jersey().register(resource);

        MongoClient mongoClient = new MongoClient("db");
        MongoDatabase database = mongoClient.getDatabase("domygroceriesdb");

        MongoCollection<Document> testCollection = database.getCollection("test");

        Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("info", new Document("x", 203).append("y", 102));

        testCollection.insertOne(doc);

    }

}
