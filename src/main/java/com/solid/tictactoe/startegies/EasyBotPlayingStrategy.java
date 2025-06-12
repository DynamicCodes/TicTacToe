package com.solid.tictactoe.startegies;

import com.solid.tictactoe.models.*;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makemove(Board board, Player player) {
        // simple startegy: choose the first available cell
        for(List<Cell> row: board.getGrid()){
            for(Cell cell: row){
                if(cell.getCellStatus().equals(CellStatus.EMPTY)){
                    return new Move(cell, player);
                }
            }
        }
        return null;
    }
}
