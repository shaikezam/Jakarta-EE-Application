package io.shaikezam;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/hello")
@ApplicationScoped
public class SimpleResource {

    @Inject
    private ISimpleService simpleService;

    @GET
    public Response getMessage() {
        return Response.ok("Hello, World!").build();
    }

    @GET
    @Path("lol")
    public Response getLol() {
        return Response.ok(simpleService.test()).build();
    }
}
