package com.solid.tictactoe.service;

import com.solid.tictactoe.models.Game;
import com.solid.tictactoe.models.Player;
import com.solid.tictactoe.startegies.WinningStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    public Game createGame(int size, List<Player> players, List<WinningStrategy> winningStrategies) {
        //return new Game(size, players, winningStrategies);
        return Game.builder()
                .withBoard(size)
                .withplayers(players)
                .withWinningStrategies(winningStrategies)
                .build();
    }

}
