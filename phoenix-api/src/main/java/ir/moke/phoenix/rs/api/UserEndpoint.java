package ir.moke.phoenix.rs.api;

import ir.moke.phoenix.da.Operator;
import ir.moke.phoenix.domain.User;
import ir.moke.phoenix.utils.KeyGenerator;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserEndpoint {

    @Context
    private UriInfo uriInfo;

    @Inject
    private KeyGenerator keyGenerator;

    @Inject
    private Operator operator;

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authentication(@FormParam("username") String username, @FormParam("password") String password) {


    }

    @POST
    public Response createUser(User user) {
        String key = "/users/-" + user.getUsername() ;
        
        operator.saveOrUpdate(key,)
    }
}
