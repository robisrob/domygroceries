package com.helpingoldies.view;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/tests")
public class TestResource {

    @GET
    public String getHelloWorld(){
        return "Hello World";
    }

}
