package ma.emsi.sabri.tp3sabri.resource;

import ma.emsi.sabri.tp3sabri.llm.GuideTouristique;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private GuideTouristique guideTouristique;

    /**
     * Retourne les informations touristiques générées
     * par Gemini pour une ville ou un pays.
     *
     * @param ville_ou_pays nom de la ville ou du pays
     * @return réponse HTTP au format JSON
     */
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response endroitsDeVisite(
            @PathParam("ville_ou_pays") String ville_ou_pays) {

        String reponseJson = guideTouristique.genererGuide(ville_ou_pays);

        return Response.ok(reponseJson, MediaType.APPLICATION_JSON).build();
    }
}