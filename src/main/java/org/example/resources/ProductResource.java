package org.example.resources;

import com.google.gson.Gson;
import org.example.domain.Product;
import org.example.services.ProductService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("products")
public class ProductResource {

    Gson gson = new Gson();
    @GET
    @Path("/{id}")
    public Response getProduct(@PathParam("id") String id) throws Exception {
        ProductService productService = new ProductService();
        return Response
                .ok(gson.toJson(productService.getProduct(id)))
                .build();
    }

    @POST
    @Path("/create")
    public Response createProduct(String payload) throws Exception {
        ProductService productService = new ProductService();
        Product product = gson.fromJson(payload, Product.class);
        productService.createProduct(product);
        return Response.ok("{\"message\":\"Successfully created\"}").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id")String id) throws Exception {
        new ProductService().deleteProduct(id);
        return Response.ok("{\"message\":\"Successfully deleted\" }").build();
    }

    @PUT
    @Path("/update")
    public Response updateProduct(String payload) throws Exception {
        ProductService productService = new ProductService();
        Product product = gson.fromJson(payload, Product.class);
        productService.updateProduct(product);
        return Response.ok("{\"message\":\"Successfully updated\"}").build();
    }

    @GET
    @Path("/all")
    public Response getAllProducts() throws Exception {
        ProductService productService = new ProductService();
        return Response.ok(gson.toJson(productService.getAllProducts())).build();
    }
}