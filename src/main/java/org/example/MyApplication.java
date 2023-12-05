package org.example;

import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {
    public MyApplication() {
        packages("org.example"); // Change this to the package where your resources are located
    }
}