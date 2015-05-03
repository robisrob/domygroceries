package com.helpingoldies.view.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by rob on 3/05/15.
 */
@Path("/tests")
public class TestResource {

    @GET
    public String getHelloWorld(){
        return "Hello World";
    }

}
