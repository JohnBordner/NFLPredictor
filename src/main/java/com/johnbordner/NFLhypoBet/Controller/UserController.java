package com.johnbordner.NFLhypoBet.Controller;
import com.johnbordner.NFLhypoBet.model.Game;
import com.johnbordner.NFLhypoBet.model.Prediction;
import com.johnbordner.NFLhypoBet.model.User;
import com.johnbordner.NFLhypoBet.service.PredictionService;
import com.johnbordner.NFLhypoBet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private PredictionService predictionService;

    @Autowired
    private UserService userService;

    // Method to display account information
    @GetMapping("/account")
    public String accountPage(Model model, Authentication authentication) {
        String username = authentication.getName();
        User user = userService.findUserByUsername(username);

        List<Prediction> userPredictions = predictionService.getPredictionsForUser(user);

        for (Prediction prediction : userPredictions) {
            Game game = prediction.getGame();

            if ("Final".equalsIgnoreCase(game.getGameStatus()) ||
                    "Final/OT".equalsIgnoreCase(game.getGameStatus()) ||
                    "Completed".equalsIgnoreCase(game.getGameStatus())) {

                // Call the evaluatePrediction method in PredictionService
                predictionService.evaluatePrediction(prediction, game);

            }

        }

        int W_count = 0;
        int L_count = 0;

        for (Prediction prediction : userPredictions) {
            Game game = prediction.getGame();

            if (prediction.isCorrect()) {
                W_count++;
            } else if ("Final".equalsIgnoreCase(game.getGameStatus()) ||
                    "Final/OT".equalsIgnoreCase(game.getGameStatus()) ||
                    "Completed".equalsIgnoreCase(game.getGameStatus())) {
                L_count++;
            }
        }

        double w_l_ratio = (L_count == 0) ? W_count : (double) W_count / L_count;

        model.addAttribute("predictions", userPredictions);
        model.addAttribute("wins", W_count);
        model.addAttribute("losses", L_count);
        model.addAttribute("winLossRatio", w_l_ratio);



        return "account";
    }

    // Additional methods for user management, profile, etc should be added
}

