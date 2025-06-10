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

    public Game(){
        this.board = null;
        this.players = new ArrayList<>();
        this.nextPlayerIndex = 0;
        this.winner = null;
        this.moves = new ArrayList<>();
        this.status = GameStatus.NOT_STARTED;
        this.winningStrategies = new ArrayList<>();
    }

    public Game(int size, List<Player> players, List<WinningStrategy> winningStrategies){
        this();
        this.board = new Board(size);
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.status = GameStatus.IN_PROGRESS;
    }

    public void display(){
        board.display();
    }
}
