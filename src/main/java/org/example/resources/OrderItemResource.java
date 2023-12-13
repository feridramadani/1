package org.example.resources;

import com.google.gson.Gson;
import org.example.domain.OrderItem;
import org.example.services.OrderItemService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("orderitems")
public class OrderItemResource {
    Gson gson = new Gson();

    @GET
    @Path("/{id}")
    public Response getOrderItem(@PathParam("id") String id) throws Exception {
        OrderItemService orderItemService = new OrderItemService();
        return Response
                .ok(gson.toJson(orderItemService.getOrderItem(id)))
                .build();
    }

    @POST
    @Path("/create")
    public Response addOrderItem(String payload) throws Exception {
        OrderItemService orderItemService = new OrderItemService();
        OrderItem orderItem = gson.fromJson(payload, OrderItem.class);
        orderItemService.addOrderItem(orderItem);
        return Response.ok("{\"message\":\"Successfully created\" }").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrderItem(@PathParam("id") String id) throws Exception {
        new OrderItemService().deleteOrderItem(id);
        return Response.ok("{\"message\":\"Successfully deleted\" }").build();
    }

    @PUT
    @Path("/update")
    public Response updateOrderItem(String payload) throws Exception {
        OrderItemService orderItemService = new OrderItemService();
        OrderItem orderItem = gson.fromJson(payload, OrderItem.class);
        orderItemService.updateOrderItem(orderItem);
        return Response.ok("{\"message\":\"Successfully updated\" }").build();
    }

    @GET
    @Path("/all")
    public Response getAllOrderItems() throws Exception {
        OrderItemService orderItemService = new OrderItemService();
        Gson gson = new Gson();
        return Response.ok(gson.toJson(orderItemService.getAllOrderItems())).build();
    }
}
