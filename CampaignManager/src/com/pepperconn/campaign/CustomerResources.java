package com.pepperconn.campaign;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by David on 27/8/2014.
 */
@Path("/customers")
public class CustomerResources {

    @GET
    @Produces("text/plain")
    public String getCustomerHelloWorld() {
        return "Hello World";
    }

    @Path("/social/fields")
    @GET
    @Produces("text/plain")
    public String getCustomerSocialFields() {
        return "Social Field1, Social Fields";
    }
}
