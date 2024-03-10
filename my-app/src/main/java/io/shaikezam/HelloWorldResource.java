package io.shaikezam;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/hello")
@ApplicationScoped
public class HelloWorldResource {

    @Inject
    private Person person;

    @GET
    public Response getMessage() {
        return Response.ok("Hello, World!").build();
    }

    @GET
    @Path("lol")
    public Response getLol() {
        return Response.ok(person.lol()).build();
    }
}
