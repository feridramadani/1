package org.example.resources;

import com.google.gson.Gson;
import org.example.domain.Payment;
import org.example.services.PaymentService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("payments")
public class PaymentResource {

    @GET
    @Path("/{id}")
    public Response getPayment(@PathParam("id")String id) throws Exception {
        PaymentService paymentService = new PaymentService();
        Gson gson = new Gson();
        return Response
                .ok(gson.toJson(paymentService.getPayment(id)))
                .build();
    }

    @POST
    @Path("/create")
    public Response createPayment(String payload) throws Exception {
        PaymentService paymentService = new PaymentService();
        Gson gson = new Gson();
        Payment payment = gson.fromJson(payload, Payment.class);
        boolean isCreated = paymentService.createPayment(payment);
        if (isCreated) return Response.ok().build();
        else return Response.serverError().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePayment(@PathParam("id")String id) throws Exception {
        PaymentService paymentService = new PaymentService();
        boolean isCreated = paymentService.deletePayment(id);
        if (isCreated) return Response.ok().build();
        else return Response.serverError().build();
    }

    @PUT
    @Path("/update")
    public Response updateOrder(String payload) throws Exception {
        PaymentService paymentService = new PaymentService();
        Gson gson = new Gson();
        Payment payment = gson.fromJson(payload, Payment.class);
        boolean isCreated = paymentService.updatePayment(payment);
        if (isCreated) return Response.ok().build();
        else return Response.serverError().build();
    }

    @GET
    @Path("/all")
    public Response getAllPayments() throws Exception {
        PaymentService paymentService = new PaymentService();
        Gson gson = new Gson();
        return Response.ok(gson.toJson(paymentService.getAllPayments())).build();
    }
}