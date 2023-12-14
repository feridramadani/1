package org.example.resources;

import com.google.gson.Gson;
import org.example.domain.Menu;
import org.example.services.MenuService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("menus")
public class MenuResource {

    Gson gson = new Gson();
    @GET
    @Path("/{id}")
    public Response getMenu(@PathParam("id")String id) throws Exception{
        MenuService menuService = new MenuService();
        return Response
                .ok(gson.toJson(menuService.getMenu(id)))
                .build();
    }

    @POST
    @Path("/create")
    public Response createMenu(String payload) throws Exception{
        MenuService menuService = new MenuService();
        Menu menu = gson.fromJson(payload, Menu.class);
        menuService.createMenu(menu);
        return Response.ok("{\"message\":\"Successfully created\"}").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMenu(@PathParam("id")String id) throws Exception{
        new MenuService().deleteMenu(id);
        return Response.ok("{\"message\":\"Successfully deleted\" }").build();
    }

    @PUT
    @Path("/update")
    public Response updateMenu(String payload) throws Exception {
        MenuService menuService = new MenuService();
        Menu menu = gson.fromJson(payload, Menu.class);
        menuService.updateMenu(menu);
        return Response.ok("{\"message\":\"Successfully updated\"}").build();
    }

    @GET
    @Path("/all")
    public Response getAllMenus() throws Exception {
        MenuService menuService = new MenuService();
        return Response.ok(gson.toJson(menuService.getAllMenus())).build();
    }
}