package com.helpingoldies.health;

import com.helpingoldies.dao.HealthCheckDAO;
import com.codahale.metrics.health.HealthCheck;
import org.skife.jdbi.v2.DBI;

public class DatabaseHealthCheck extends HealthCheck{

    private final HealthCheckDAO healthCheckDAO;


    public DatabaseHealthCheck(DBI jdbi) {
        healthCheckDAO = jdbi.onDemand(HealthCheckDAO.class);
    }

    @Override
    protected Result check() throws Exception {
        if(healthCheckDAO.pingDatabase()) {
            return Result.healthy();
        }
        return Result.unhealthy("Can't ping database");
    }
}

