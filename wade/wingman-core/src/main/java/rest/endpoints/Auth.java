package rest.endpoints;

import auth.AuthManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/auth")
public class Auth {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getCoffee(
        @QueryParam("username") String user,
        @QueryParam("password") String password
    ) {
        System.out.println(user);
        System.out.println(password);


        if (AuthManager.authenticate(user, password)) {
            System.out.println("success");
            return "success";
        }

        return "false";
    }

}
