package com.pepperconn.campaign;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by David on 27/8/2014.
 */
@ApplicationPath("/api")
public class CampaignApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new HashSet<Class<?>>();

        resources.add(CustomerResources.class);

        return resources;
    }
}