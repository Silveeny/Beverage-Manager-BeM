package endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.JenaWrapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Path("/search")
public class MasterSearch {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String search(
        @QueryParam("country") String country,
        @QueryParam("ingredients") String ingredients,
        @QueryParam("restrictions") String restrictions,
        @QueryParam("events") String events,
        @QueryParam("username") String user
    ) throws IOException {


        ObjectMapper mapper = new ObjectMapper();

        List<String> ingredientsRaw = ingredients != null
            ? Arrays.asList(mapper.readValue(ingredients, String[].class))
            : Arrays.asList();
        List<String> restrictionsRaw = restrictions != null
            ? Arrays.asList(mapper.readValue(restrictions, String[].class))
            : Arrays.asList();
        List<String> eventsRaw = events != null
            ? Arrays.asList(mapper.readValue(events, String[].class))
            : Arrays.asList();

        // cal the ontology api here

        System.out.println(country);
        System.out.println(ingredientsRaw);
        System.out.println(restrictionsRaw);
        System.out.println(eventsRaw);


        List<String> ss = JenaWrapper.search(user, country, ingredientsRaw, restrictionsRaw, eventsRaw);

        return writeListToJsonArray(ss);
    }


    public String writeListToJsonArray(List<String> lstt) throws IOException {

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(out, lstt);

        final byte[] data = out.toByteArray();

        return (new String(data));
    }
}


