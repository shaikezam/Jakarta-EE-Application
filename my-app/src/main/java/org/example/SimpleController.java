package org.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("hello")
public class SimpleController {

    @GET
    @Path("persons")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersons() {
        return List.of(new Person(1, "A"), new Person(1, "B"));
    }

    @GET
    @Path("aaa")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test() {
        return Response.ok(getPersons()).build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, World!";
    }
}
