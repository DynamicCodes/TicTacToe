package com.solid.tictactoe.controller;

import com.solid.tictactoe.models.Game;
import com.solid.tictactoe.models.GameStatus;
import com.solid.tictactoe.models.Player;
import com.solid.tictactoe.service.GameService;
import com.solid.tictactoe.startegies.WinningStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GameController {

    //after adding service layer
    private final GameService gameService;
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }


    //start game
    public Game startGame(int size, List<Player> players, List<WinningStrategy> winningStrategy) {
        return gameService.createGame(size, players, winningStrategy);
    }

    //make move
    public void makeMove(Game game) {

    }

    //get game status
    public GameStatus getGameStatus(Game game) {
        return game.getStatus();
    }

    //display game
    public void display(Game game) {
        game.display();
    }

    //winner
    public String getWinner(Game game) {
         return "Finding winner logic here";
    }


}
