package org.acme;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "db.username")
    String username;

    @ConfigProperty(name = "db.password")
    String password;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("db")
    @RolesAllowed("admin")
    public String db() {
        return username + ":" + password;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("user")
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }
}
