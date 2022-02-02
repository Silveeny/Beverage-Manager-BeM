package rest.endpoints;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Path("/search")
public class MasterSearch {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String search(
        @QueryParam("country") String country,
        @QueryParam("ingredients") String ingredients,
        @QueryParam("restrictions") String restrictions,
        @QueryParam("events") String events,
        @QueryParam("username") String username
    ) throws IOException {
        Client client = ClientBuilder.newClient();

        String coffee = client.target("http://host.docker.internal:8081/brain/api/search")
            .queryParam("country", country)
            .queryParam("ingredients", ingredients)
            .queryParam("restrictions", restrictions)
            .queryParam("events", events)
            .queryParam("username", username)
            .request(MediaType.APPLICATION_JSON)
            .get(String.class);

//        ObjectMapper mapper = new ObjectMapper();
//
//        List<String> ingredientsRaw = Arrays.asList(mapper.readValue(ingredients, String[].class));
//        List<String> restrictionsRaw = Arrays.asList(mapper.readValue(restrictions, String[].class));
//        List<String> eventsRaw = Arrays.asList(mapper.readValue(events, String[].class));

//        System.out.println(country);
//        System.out.println(ingredientsRaw);
//        System.out.println(restrictionsRaw);
//        System.out.println(eventsRaw);
        System.out.println(coffee);

        return coffee;
    }
}
