package com.solid.tictactoe.models;

import com.solid.tictactoe.startegies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
@lombok.Getter
@lombok.Setter
public class Game {
    private Board board;
    private List<Player> players;
    private int nextPlayerIndex;
    private Player winner;
    private List<Move> moves;
    private GameStatus status;
    private List<WinningStrategy> winningStrategies;

    private Game(){
        this.board = null;
        this.players = new ArrayList<>();
        this.nextPlayerIndex = 0;
        this.winner = null;
        this.moves = new ArrayList<>();
        this.status = GameStatus.NOT_STARTED;
        this.winningStrategies = new ArrayList<>();
    }

//    public Game(int size, List<Player> players, List<WinningStrategy> winningStrategies){
//        this();
//        this.board = new Board(size);
//        this.players = players;
//        this.winningStrategies = winningStrategies;
//        this.status = GameStatus.IN_PROGRESS;
//    }

    public static Builder builder(){
        return new Builder();
    }

    public void display(){
        board.display();
    }

    public static class Builder{
        private final Game game;

        private Builder(){
            game = new Game();
        }

        public Builder withBoard(int size){
            game.board = new Board(size);
            return this;
        }
        public Builder withplayers(List<Player> players){
            game.players = players;
            return this;
        }
        public Builder withWinningStrategies(List<WinningStrategy> winningStrategies){
            game.winningStrategies = winningStrategies;
            return this;
        }
        public Game build() {
            if (game.board == null) {
                throw new IllegalStateException("Board is required");
            }
            if (game.players == null || game.players.isEmpty()) {
                throw new IllegalStateException("Players are required");
            }
            game.status = GameStatus.IN_PROGRESS;
            return game;
        }
    }
}
