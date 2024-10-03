package com.johnbordner.NFLhypoBet.service;


/*
import com.johnbordner.NFLhypoBet.model.*;
import com.johnbordner.NFLhypoBet.repository.PredictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredictionService {
    @Autowired
    private PredictionRepository predictionRepository;

    public List<Prediction> getPredictionsForUser(User user) {
        return predictionRepository.findByUser(user);
    }

    public Prediction savePrediction(Prediction prediction) {
        return predictionRepository.save(prediction);
    }

    public void evaluatePrediction(Prediction prediction, Game game) {
        boolean coversSpread = (game.getHomeScore() - game.getAwayScore()) > game.getSpread();
        prediction.setCorrect(prediction.isPrediction() == coversSpread);
        predictionRepository.save(prediction);
    }
}
*/