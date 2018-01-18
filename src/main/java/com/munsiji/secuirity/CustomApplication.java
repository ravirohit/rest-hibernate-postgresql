package com.munsiji.secuirity;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class CustomApplication extends ResourceConfig
{
    public CustomApplication()
    {
    	System.out.println("-----------customApplication----------");
        packages("com.munsiji");
        //register(LoggingFilter.class); 
        //Register Auth Filter here
        register(AuthenticationFilter.class);
    }
}