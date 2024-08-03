package io.shaikezam.controller;

import io.shaikezam.model.ProductDTO;
import io.shaikezam.service.IProductService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

import java.util.logging.Logger;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
@ApplicationScoped
public class ProductResource {

    private static final Logger logger = Logger.getLogger(ProductResource.class.getName());

    private final IProductService productService;

    @GET
    public Response getAllProducts() {
        return Response.ok(productService.getAllProducts()).build();
    }

    @POST
    public Response createProduct(ProductDTO productDTO) {
        productService.createNewProduct(productDTO);
        return Response.accepted().build();
    }

    @GET
    @Path("/{productId}")
    public Response getProduct(@PathParam("productId") long productId) {
        return productService.getProduct(productId)
                .map(product -> Response.ok(product).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).entity("Product not found").build());

    }

    @GET
    @Path("/{productId}/name")
    public Response getProductName(@PathParam("productId") long productId) {
        return productService.getProductName(productId)
                .map(product -> Response.ok(product).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).entity("Product not found").build());

    }

    @PUT
    @Path("/{productId}")
    public Response updateProduct(@PathParam("productId") long productId, ProductDTO productDTO) {
        productService.updateProduct(productId, productDTO);
        return Response.accepted().build();
    }

    @DELETE
    @Path("/{productId}")
    public Response deleteProduct(@PathParam("productId") long productId) {
        productService.deleteProduct(productId);
        return Response.accepted().build();
    }

}
