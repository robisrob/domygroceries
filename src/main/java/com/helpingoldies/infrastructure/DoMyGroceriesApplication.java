package com.helpingoldies.infrastructure;


import com.helpingoldies.view.TestResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;


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
    }
}
