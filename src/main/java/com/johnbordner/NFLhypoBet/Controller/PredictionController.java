/*


package com.johnbordner.NFLhypoBet.Controller;

import com.johnbordner.NFLhypoBet.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.johnbordner.NFLhypoBet.model.*;
import com.johnbordner.NFLhypoBet.service.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/predictions")
public class PredictionController {
    @Autowired
    private PredictionService predictionService;

    @Autowired
    private GameService gameService;

    @Autowired
    private UserService userService;

    @PostMapping("/submit")
    public String submitPrediction(@RequestParam Long gameId, @RequestParam boolean covers, Principal principal) {
        User user = userService.findUserByUsername(principal.getName());

        // Game game = gameService.getGameById(gameId);

        Prediction prediction = new Prediction();
        prediction.setUser(user);
        // prediction.setGame(game);
        prediction.setPrediction(covers);

        predictionService.savePrediction(prediction);
        return "redirect:/predictions";
    }

    @GetMapping
    public String showPredictions(Model model, Principal principal) {
        User user = userService.findUserByUsername(principal.getName());
        List<Prediction> predictions = predictionService.getPredictionsForUser(user);
        model.addAttribute("predictions", predictions);
        return "predictions";
    }
}
*/
