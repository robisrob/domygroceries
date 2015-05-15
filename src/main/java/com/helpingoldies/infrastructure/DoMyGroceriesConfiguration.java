package com.helpingoldies.infrastructure;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

public class DoMyGroceriesConfiguration extends Configuration {

    @JsonProperty @NotEmpty
    public String mongohost = "db";

    @JsonProperty
    public int mongoport = 27017;

    @JsonProperty @NotEmpty
    public String mongodb = "yourdb";
}
