package com.helpingoldies;

import com.helpingoldies.health.DatabaseHealthCheck;
import com.helpingoldies.resources.GroceryItemResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class App extends Application<DoMyGroceriesConfiguration>
{

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) throws Exception {
        new App().run(args);
    }

    @Override
    public void run(DoMyGroceriesConfiguration configuration, Environment environment) throws Exception {
        LOGGER.info("Method App#run() called");
        final DBIFactory factory = new DBIFactory();
        DataSourceFactory database = configuration.getDatabase();
        final DBI jdbi = factory.build(environment, database, "mysql");
        environment.jersey().register(new GroceryItemResource(jdbi));

        environment.healthChecks().register("Database health check", new DatabaseHealthCheck(jdbi));
    }
}
