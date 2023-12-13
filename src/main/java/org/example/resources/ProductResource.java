package org.example.resources;

import com.google.gson.Gson;
import org.example.domain.Product;
import org.example.services.ProductService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("products")
public class ProductResource {
    @GET
    @Path("/{id}")
    public Response getProduct(@PathParam("id") String id) throws Exception {
        ProductService productService = new ProductService();
        Gson gson = new Gson();
        return Response
                .ok(gson.toJson(productService.getProduct(id)))
                .build();
    }

    @POST
    @Path("/create")
    public Response createProduct(String payload) throws Exception {
        ProductService productService = new ProductService();
        Gson gson = new Gson();
        Product product = gson.fromJson(payload, Product.class);
        boolean isCreated = productService.createProduct(product);
        if (isCreated) return Response.ok().build();
        else return Response.serverError().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id")String id) throws Exception {
        ProductService productService = new ProductService();
        boolean isCreated = productService.deleteProduct(id);
        if (isCreated) return Response.ok().build();
        else return Response.serverError().build();
    }

    @PUT
    @Path("/update")
    public Response updateProduct(String payload) throws Exception {
        ProductService productService = new ProductService();
        Gson gson = new Gson();
        Product product = gson.fromJson(payload, Product.class);
        boolean isCreated = productService.updateProduct(product);
        if (isCreated) return Response.ok().build();
        else return Response.serverError().build();
    }

    @GET
    @Path("/all")
    public Response getAllProducts() throws Exception {
        ProductService productService = new ProductService();
        Gson gson = new Gson();
        return Response.ok(gson.toJson(productService.getAllProducts())).build();
    }


}
