package ir.moke.phoenix.rs.api;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import ir.moke.phoenix.da.Operator;
import ir.moke.phoenix.utils.KeyGenerator;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.security.Key;
import java.util.Date;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

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
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser(JsonObject object) {
        String username = object.getString("username");
        String password = object.getString("password");
        if (object == null ||
                username.equals("") ||
                username.equals(null) ||
                password.equals("") ||
                password.equals(null)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        try {
            authenticate(username, password);
            String token = issueToken(username);
            return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();
        } catch (Exception e) {
            return Response.ok().status(UNAUTHORIZED).build();
        }
    }

    @POST
    @Path("/register")
    public Response createUser(JsonObject object) {
        String key = "/users/-/" + object.getString("username");
        operator.saveOrUpdate(key, object.toString());
        return Response.ok().build();
    }

    private void authenticate(String username, String password) {
        JsonObject result = operator.select("/users/-/" + username);
        if (result != null) {
            JsonObject user = result.getJsonObject("/" + username);
            String dbPass = user.getString("password");
            if (!dbPass.equals(password)) {
                throw new SecurityException("Invalid Username/Password");
            }
        } else {
            throw new SecurityException("Invalid Username/Password");
        }
    }

    private String issueToken(String username) {
        Key key = keyGenerator.generateKey();
        return Jwts.builder()
                .setSubject(username)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }
}
