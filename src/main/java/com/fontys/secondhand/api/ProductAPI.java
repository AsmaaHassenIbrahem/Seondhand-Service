package com.fontys.secondhand.api;

import com.fontys.secondhand.model.Product;
import com.fontys.secondhand.service.ProductService;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("products")
@Singleton
public class ProductAPI {

    ProductService productService;

    public ProductAPI() {
        productService = new ProductService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {
        return Response.accepted(productService.getAllProducts()).build();
    }

    @Path("sell")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response sellProduct(Product product) {
        if (productService.sellProduct(product)){
            return Response.accepted(true).build();
        }
        else return Response.serverError().entity("Failed to sell product , please try again").build();
    }

    @Path("buy")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response buyProduct(Product product) {
        if (productService.buyProduct(product)){
            return Response.accepted(true).build();
        }
        else return Response.serverError().entity("Failed to buy product , please try again").build();
    }
}
