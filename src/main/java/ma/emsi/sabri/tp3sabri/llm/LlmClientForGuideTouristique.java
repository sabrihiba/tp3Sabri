package ma.emsi.sabri.tp3sabri.llm;


import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.model.chat.request.ResponseFormat;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class LlmClientForGuideTouristique {

    @Produces
    @ApplicationScoped
    public GuideTouristique creerGuideTouristique() {

        String apiKey = System.getenv("GEMINI_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException(
                    "La variable GEMINI_KEY est manquante."
            );
        }

        ChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-3.8-flash")
                .temperature(0.2)
                .responseFormat(ResponseFormat.JSON)
                .build();

        return AiServices.create(GuideTouristique.class, model);
    }
}
