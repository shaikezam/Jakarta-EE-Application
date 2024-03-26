package io.shaikezam.controller;

import io.shaikezam.service.IOrderService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.logging.Logger;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class OrderResource {

    private static final Logger logger = Logger.getLogger(OrderResource.class.getName());

    @Inject
    private IOrderService orderService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrders() {
        return Response.ok(orderService.getAllOrders()).build();
    }

}
