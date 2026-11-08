package ma.emsi.sabri.tp3sabri.resource;

import ma.emsi.sabri.tp3sabri.llm.GuideTouristique;

import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private GuideTouristique guideTouristique;

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response endroitsDeVisite(
            @PathParam("ville_ou_pays") String ville_ou_pays,
            @QueryParam("nb") @DefaultValue("2") int nb) {

        if (nb < 1) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"erreur\":\"Le nombre d'endroits doit être supérieur à 0\"}")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }

        String reponseJson = guideTouristique.genererGuide(
                ville_ou_pays + ". Donne exactement " + nb + " endroits à visiter."
        );

        return Response.ok(reponseJson, MediaType.APPLICATION_JSON).build();
    }
}