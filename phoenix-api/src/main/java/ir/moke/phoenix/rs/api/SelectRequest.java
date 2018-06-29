package ir.moke.phoenix.rs.api;

import ir.moke.phoenix.da.Operator;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/*
 *
 * URL like this :
 *      http://localhost:8080/api/v1/phoenix/
 *
 * */

@Path("/phoenix")
public class SelectRequest {

    @Inject
    private Operator operator;

    @Path("{clientId}")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("clientId") String cid, String key) {
        if (key == null || key == "") {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        JsonObject object = operator.select(key);
        return Response.ok(object).build();
    }

    @Path("{clientId}")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll(@PathParam("clientId") String cid, String key) {
        if (key == null || key == "") {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        JsonObject object = operator.selectAll(key);
        return Response.ok(object).build();
    }

    @Path("{clientId}")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response save(@PathParam("clientId") String cid, String key) {
        if (key == null || key == "") {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        JsonObject object = operator.select(key);
        return Response.ok(object).build();
    }
}
