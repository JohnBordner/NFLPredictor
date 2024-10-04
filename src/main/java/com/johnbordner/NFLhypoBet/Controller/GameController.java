package com.johnbordner.NFLhypoBet.Controller;

import com.johnbordner.NFLhypoBet.model.Game;
// import com.johnbordner.NFLhypoBet.service.GameService;
import com.johnbordner.NFLhypoBet.service.GameService;
import com.johnbordner.NFLhypoBet.service.RapidApiNflService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {


    @Autowired
    private GameService gameService;



    @Autowired
    private RapidApiNflService rapidApiNflService;


/*
    @GetMapping
    public String showGames(Model model) {
        List<Game> games = gameService.getAllGames();
        model.addAttribute("games", games);
        return "games";
    }
*/

    @GetMapping("/nfl")
    public String getNflGames(@RequestParam("gameWeek")String gameWeek, @RequestParam("seasonType") String seasonType,
                              @RequestParam("season") String season, Model model) {

        List <Game> games= gameService.getGameByWeekTypeSeason(gameWeek, seasonType, season);

        if (games == null || games.isEmpty()) {

            games = rapidApiNflService.getNflGames(gameWeek, seasonType, season);

            for (Game game : games) {
                game.setFormattedGameDate(game.getGameDate());
            }

            if (!games.isEmpty()) {
                saveGamesToDatabase(games); // Save only if games is not null and not empty

            }
        }


        model.addAttribute("games", games);

        return "nfl";  // View to display NFL games
    }
    private void saveGamesToDatabase(List<Game> games) {
        for (Game game : games) {
            // Check if the game already exists
            if (!gameService.existsByGameID(game.getGameID())) {
                gameService.saveGame(game); // Save the game if it doesn't exist
            }
        }
    }




}