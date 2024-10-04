package com.johnbordner.NFLhypoBet.service;

import com.johnbordner.NFLhypoBet.model.Game;
import com.johnbordner.NFLhypoBet.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    public Game getGameById(String gameID) {
        return gameRepository.findBygameID(gameID);
    }

    public boolean existsByGameID(String gameID) {
        return gameRepository.existsByGameID(gameID);
    }

    public List<Game> getGameByWeekTypeSeason(String week, String type, String season) {
        return gameRepository.findByGameWeekAndSeasonTypeAndSeason(week, type, season);

    }


}

