package com.johnbordner.NFLhypoBet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://tank01-nfl-live-in-game-real-time-statistics-nfl.p.rapidapi.com")
                .defaultHeader("x-rapidapi-key", "6ef2858a9bmshaa9008c83e05a93p160af3jsn869320124169")
                .defaultHeader("x-rapidapi-host", "tank01-nfl-live-in-game-real-time-statistics-nfl.p.rapidapi.com")
                .build();
    }
}
