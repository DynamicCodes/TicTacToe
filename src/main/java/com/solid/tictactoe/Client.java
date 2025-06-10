package com.solid.tictactoe;

import com.solid.tictactoe.controller.GameController;
import com.solid.tictactoe.models.*;
import com.solid.tictactoe.service.GameService;

import java.util.List;

public class Client {
    public static void main(String[] args) {

        GameService gameService = new GameService();
        GameController gameController = new GameController(gameService);

        Player p1 = new HumanPlayer("david", new Symbol('X'), 25, 1);
        Player p2 = new Bot("Bot", BotDifficultyLevel.EASY);

        Game game = gameController.startGame(
                3,
                List.of(p1, p2),
                null
        );

        gameController.display(game);

        // Example of making a move
        while (gameController.getGameStatus(game) == GameStatus.IN_PROGRESS) {
            gameController.makeMove(game);
            gameController.display(game);

            //temp
            game.setStatus(GameStatus.DRAW);
        }
        if(gameController.getGameStatus(game) == GameStatus.SUCCESS) {
            System.out.println("Winner: " + gameController.getWinner(game));
        }else if(gameController.getGameStatus(game) == GameStatus.DRAW) {
            System.out.println("Game is Draw");
        }
    }
}
