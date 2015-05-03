package com.helpingoldies.infrastructure.rest;


import com.helpingoldies.view.rest.TestResource;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rob on 3/05/15.
 */
public class DoMyGroceriesApplication extends Application{

    private Set<Object> singletons = new HashSet<>();
    private Set<Class<?>> classes = new HashSet<>();

    public DoMyGroceriesApplication() {
        singletons.add(new TestResource());
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
