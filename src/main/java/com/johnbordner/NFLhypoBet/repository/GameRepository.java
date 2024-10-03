package com.johnbordner.NFLhypoBet.repository;
import com.johnbordner.NFLhypoBet.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameRepository extends JpaRepository<Game, Long> {
}