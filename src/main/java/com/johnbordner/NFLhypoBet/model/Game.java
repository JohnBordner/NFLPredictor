package com.johnbordner.NFLhypoBet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String gameID;
    private String seasonType;
    private String home;
    private String away;

    private int homeScore;
    private int awayScore;
    private String gameDate;
    private String gameTime;
    private String gameStatus;




}
