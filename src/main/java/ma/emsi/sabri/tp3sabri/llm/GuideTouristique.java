package ma.emsi.sabri.tp3sabri.llm;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface GuideTouristique {

    @SystemMessage("""
            Tu es un guide touristique professionnel.

            Pour la ville ou le pays demandé, indique :
            - Les 2 principaux endroits à visiter.
            - Le prix moyen d'un repas dans la devise du pays.

            Réponds uniquement au format JSON suivant :
            {
              "ville_ou_pays": "nom de la ville ou du pays",
              "endroits_a_visiter": ["endroit 1", "endroit 2"],
              "prix_moyen_repas": "prix devise du pays"
            }

            N'utilise pas Markdown.
            N'ajoute aucune explication en dehors du JSON.
            """)
    String genererGuide(@UserMessage String villeOuPays);
}