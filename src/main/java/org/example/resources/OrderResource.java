package org.example.resources;

import com.google.gson.Gson;
import org.example.domain.Order;
import org.example.services.OrderService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("orders")
public class OrderResource {

    @GET
    @Path("/{id}")
    public Response getOrder(@PathParam("id") String id) throws Exception {
        OrderService orderService = new OrderService();
        Gson gson = new Gson();
        return Response
                .ok(gson.toJson(orderService.getOrder(id)))
                .build();
    }

    @POST
    @Path("/create")
    public Response createOrder(String payload) throws Exception {
        OrderService orderService = new OrderService();
        Gson gson = new Gson();
        Order order = gson.fromJson(payload, Order.class);
        boolean isCreated = orderService.createOrder(order);
        if (isCreated) return Response.ok().build();
        else return Response.serverError().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id")String id) throws Exception {
        OrderService orderService = new OrderService();
        boolean isCreated = orderService.deleteOrder(id);
        if (isCreated) return Response.ok().build();
        else return Response.serverError().build();
    }

    @PUT
    @Path("/update")
    public Response updateOrder(String payload) throws Exception {
        OrderService orderService = new OrderService();
        Gson gson = new Gson();
        Order order = gson.fromJson(payload, Order.class);
        boolean isCreated = orderService.updateOrder(order);
        if (isCreated) return Response.ok().build();
        else return Response.serverError().build();
    }

    @GET
    @Path("/all")
    public Response getAllOrders() throws Exception {
        OrderService orderService = new OrderService();
        Gson gson = new Gson();
        return Response.ok(gson.toJson(orderService.getAllOrders())).build();
    }
}