package com.fontys.secondhand.api;

import com.fontys.secondhand.model.User;
import com.fontys.secondhand.service.UserService;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
@Singleton
public class UserAPI {
    UserService userService;

    public UserAPI() {
        userService = new UserService();
    }

    @Path("signup")
    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAccount(User user) {
        if (userService.createAccount(user.getEmail(), user.getPassword(), user.getName())) {
            return Response.accepted("Account Created").build();
        } else
            return Response.serverError().entity("Failed to create account , please try again").build();
    }

    @Path("login")
    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(User user) {
        userService.login(user.getEmail(), user.getPassword());
        if (user != null) {
            return Response.accepted(user).build();
        } else
            return Response.serverError().entity("Failed to login , please try again").build();
    }

}
