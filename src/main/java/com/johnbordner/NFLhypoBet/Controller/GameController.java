package com.johnbordner.NFLhypoBet.Controller;

import com.johnbordner.NFLhypoBet.model.Game;
// import com.johnbordner.NFLhypoBet.service.GameService;
import com.johnbordner.NFLhypoBet.service.RapidApiNflService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GameController {

    /*
    @Autowired
    private GameService gameService;
    */


    @Autowired
    private RapidApiNflService rapidApiNflService;


    //Uncomment all GameService related comments when database is implemented
    /*
    @GetMapping
    public String showGames(Model model) {
        List<Game> games = gameService.getAllGames();
        model.addAttribute("games", games);
        return "games";
    }

     */
    @GetMapping("/nfl")
    public String getNflGames(@RequestParam("week")String week, Model model) {
        List <Game> games= rapidApiNflService.getNflGames(week, "reg", "2024");
        model.addAttribute("games", games);

        return "nfl";  // View to display NFL games
    }


}