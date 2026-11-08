package ma.emsi.sabri.tp3sabri;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello-world")
public class HelloResource {

    @GET
    @Path("personnes/{nom}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("nom") String nom) {
        return "Hello, " + nom;
    }
}