package ir.moke.phoenix.rs.api;

import ir.moke.phoenix.da.Operator;
import oracle.kv.Key;
import oracle.kv.Value;
import oracle.kv.ValueVersion;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

/*
 *
 * URL like this :
 *      http://localhost:8080/api/v1/phoenix/
 *
 * */

@Path("/phoenix")
@Produces({"application/json","text/xml"})
public class SelectRequest {

    @Inject
    private Operator operator;

    @Path("{clientId}")
    @POST
    public Response find(@PathParam("clientId") String cid, @QueryParam("key") String key) {
        Value value = operator.select("/sample");
        return Response.ok(value).build();
    }


    @Path("/sample")
    @POST
    public Response findTest() {
        Map<Key,Value> map = operator.selectAll("/mah454/-/persons");
        return Response.ok(map).build();
    }
}
