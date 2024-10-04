package com.johnbordner.NFLhypoBet.Controller;
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
        model.addAttribute("predictions", userPredictions);
        return "account";
    }

    // Additional methods for user management (e.g., profile, settings) can be added here
}

