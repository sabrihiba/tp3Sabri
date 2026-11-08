Utilisation de l'intelligence artificielle — TP 3
Projet : tp3Sabri
Étudiante : Hiba Sabri
Sujet : Application REST avec Jakarta EE, LangChain4j et Gemini
1. Outils d'intelligence artificielle utilisés
- ChatGPT : accompagnement pédagogique pour comprendre les consignes, expliquer les concepts Java/Jakarta EE et proposer des exemples de code à adapter au projet.
- Gemini via LangChain4j : modèle de langage intégré à l'application REST afin de générer les informations touristiques demandées par l'utilisateur.
2. Utilisation de ChatGPT pendant le développement
   J'ai sollicité ChatGPT pour avancer progressivement dans les différentes parties du TP et obtenir des explications détaillées sur les modifications proposées.

Les échanges ont notamment porté sur :
- Le rôle des classes de configuration et de ressources REST, ainsi que les annotations JAX-RS (@ApplicationPath, @Path, @GET, @Produces, @PathParam).
- La création de la ressource GuideTouristiqueResource et le retour d'un tableau Java sérialisé en JSON.
- La définition de l'interface GuideTouristique avec les annotations LangChain4j @SystemMessage et @UserMessage.
- La proposition d'une classe de configuration du modèle Gemini avec GoogleGenAiChatModel et AiServices.
- L'explication de l'injection de dépendances CDI avec @Inject, @Produces et @ApplicationScoped.
- La construction d'une réponse HTTP avec Response.ok(...) et le type application/json.
- Le bonus permettant de choisir le nombre d'endroits à visiter à l'aide de @QueryParam("nb") et @DefaultValue("2").
- L'adaptation du prompt système pour que le nombre d'endroits soit variable.
- La préparation des informations demandées dans l'email de fin de TP.
  Les extraits de code fournis par ChatGPT ont servi de propositions de mise en œuvre et de supports d'explication. Ils ont été intégrés et testés dans le cadre du projet.
3. Utilisation de Gemini dans l'application
   L'application expose un endpoint REST qui reçoit le nom d'une ville ou d'un pays. Elle utilise LangChain4j pour transmettre à Gemini un message système définissant le rôle de guide touristique et un message utilisateur contenant le lieu demandé.

Le modèle doit retourner un objet JSON comprenant :
- ville_ou_pays ;
- endroits_a_visiter ;
- prix_moyen_repas.
  Dans la version avec bonus, le nombre d'éléments de endroits_a_visiter dépend du paramètre de requête nb, dont la valeur par défaut est 2.
4. Tests et résultats communiqués
   Un test sur Nice a produit la réponse suivante :
   {
   "ville_ou_pays": "Nice",
   "endroits_a_visiter": [
   "La Promenade des Anglais",
   "La Colline du Château"
   ],
   "prix_moyen_repas": "20 €"
   }
   Le fonctionnement du bonus avec un nombre d'endroits configurable a également été confirmé. La sortie exacte de ce test n'a pas été recopiée ici, faute de journal d'exécution complet fourni.
5. Vérification et limites
   Les réponses générées par un LLM peuvent varier selon les appels. Les lieux proposés et les prix moyens de repas sont des informations générées, qui ne constituent pas des données touristiques vérifiées en temps réel.

Le prompt demande un format JSON précis, mais une validation automatique de la structure serait nécessaire pour garantir sa conformité dans une application de production.

Les suggestions de ChatGPT ne remplacent pas la compilation, le déploiement et les tests réels de l'application.
6. Synthèse
   ChatGPT a été utilisé comme assistant pédagogique et aide au développement. Gemini constitue le service d'IA appelé par l'application REST. Le TP a permis de mettre en pratique JAX-RS, CDI, LangChain4j, la génération de JSON et le passage de paramètres dans les URL REST.