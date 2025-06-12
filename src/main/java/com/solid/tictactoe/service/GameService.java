package com.solid.tictactoe.service;

import com.solid.tictactoe.models.*;
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

    public void makeMove(Game game){
        Player currentPlayer = game.getPlayers().get(game.getNextPlayerIndex());
        System.out.println("It is " + currentPlayer.getName() + "'s turn");

        // Logic to make a move
        Move move = currentPlayer.makeMove(game.getBoard());

        if(!validate(move, game)){
            System.out.println("Invalid move. Try again.");
            return;
        }

        //update the game
        updateGame(move, currentPlayer, game);

        //check for winner
        if(checkWinner(move, game)){
            game.setWinner(currentPlayer);
            game.setStatus(GameStatus.SUCCESS);
        }else if(checkDraw(game)){
            game.setStatus(GameStatus.DRAW);
        }

        game.setNextPlayerIndex((game.getNextPlayerIndex() + 1) % game.getPlayers().size());
    }
    private boolean validate(Move move, Game game) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row < 0 || row >= game.getBoard().getSize() || col < 0 || col >= game.getBoard().getSize() ){
            return false;
        }
        return move.getCell().getCellStatus().equals(CellStatus.EMPTY);
    }

    private void updateGame(Move move, Player currentPlayer, Game game){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cellToChange = game.getBoard().getGrid().get(row).get(col);
        cellToChange.setCellStatus(CellStatus.OCCUPIED);
        cellToChange.setPlayer(currentPlayer);

        move.setCell(cellToChange);
        move.setPlayer(currentPlayer);
        game.getMoves().add(move);
    }
    private boolean checkWinner(Move move, Game game){
        for(WinningStrategy winningStrategy : game.getWinningStrategies()){
            if(winningStrategy.checkWinner(game.getBoard(), move)){
                return true;
            }
        }
        return false;
    }
    private boolean checkDraw(Game game){
        return game.getMoves().size() == game.getBoard().getSize() * game.getBoard().getSize();
    }

}
