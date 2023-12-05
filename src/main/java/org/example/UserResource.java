package org.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserResource {
    private UserRepository userRepository = new UserRepository();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") int id) {
        User user = userRepository.getUserById(id);

        if (user != null) {
            return Response.status(Response.Status.OK)
                    .entity(user)
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User not found with ID: " + id)
                    .build();
        }
    }
}
