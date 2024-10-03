package com.johnbordner.NFLhypoBet.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.johnbordner.NFLhypoBet.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class RapidApiNflService {
    @Autowired
    private WebClient webClient;


    @Autowired
    private ObjectMapper objectMapper;

    private static final String URL = "rapidapi.com";


    public List<Game> getNflGames(String week, String seasonType, String season) {
        String jsonResponse = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/getNFLGamesForWeek")
                        .queryParam("week", week)
                        .queryParam("seasonType", seasonType)
                        .queryParam("season", season)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();  // Blocking call to get the response

        // Process the JSON response and convert it into a List<Game>
        try {
            // Parse the response into a JsonNode
            JsonNode rootNode = objectMapper.readTree(jsonResponse);  // Parse the JSON string
            JsonNode gamesNode = rootNode.get("body");  // Extract the 'body' array

            // Convert the 'body' node into a List of Game objects
            return objectMapper.convertValue(gamesNode, new TypeReference<List<Game>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return null;  // Return null in case of errors
        }
    }

}
