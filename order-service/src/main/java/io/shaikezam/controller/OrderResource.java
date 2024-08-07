package io.shaikezam.controller;

import io.shaikezam.model.OrderDTO;
import io.shaikezam.service.IOrderService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

import java.util.logging.Logger;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
@ApplicationScoped
public class OrderResource {

    private static final Logger logger = Logger.getLogger(OrderResource.class.getName());

    private final IOrderService orderService;

    @GET
    public Response getAllOrders() {
        logger.info("Get all orders");
        return Response.ok(orderService.getAllOrders()).build();
    }

    @POST
    public Response createOrder(OrderDTO orderDTO) {
        orderService.createNewOrder(orderDTO);
        return Response.accepted().build();
    }

    @GET
    @Path("/{orderId}")
    public Response getOrder(@PathParam("orderId") long orderId) {
        return orderService.getOrder(orderId)
                .map(order -> Response.ok(order).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).entity("Order not found").build());

    }

    @PUT
    @Path("/{orderId}")
    public Response updateOrder(@PathParam("orderId") long orderId, OrderDTO orderDTO) {
        orderService.updateOrder(orderId, orderDTO);
        return Response.accepted().build();
    }

    @DELETE
    @Path("/{orderId}")
    public Response deleteOrder(@PathParam("orderId") long orderId) {
        orderService.deleteOrder(orderId);
        return Response.accepted().build();
    }

}
