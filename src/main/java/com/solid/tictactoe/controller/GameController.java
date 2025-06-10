package com.solid.tictactoe.controller;

import com.solid.tictactoe.models.Game;
import com.solid.tictactoe.models.GameStatus;
import com.solid.tictactoe.models.Player;
import com.solid.tictactoe.startegies.WinningStrategy;

import java.util.List;

public class GameController {
    //start game
    public Game startGame(int size, List<Player> players, List<WinningStrategy> winningStrategy) {
        return new Game(size, players, winningStrategy);
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
