package com.solid.tictactoe.startegies;

import com.solid.tictactoe.models.Board;
import com.solid.tictactoe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {
    private Map<Integer, HashMap<Character, Integer>> rowCounts = new HashMap<>();
    //{row : {symbol : count}}

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Character ch = move.getPlayer().getSymbol().getSymbol();

        if(!rowCounts.containsKey(row)){
            rowCounts.put(row, new HashMap<>());
        }

        Map<Character, Integer> rowMap = rowCounts.get(row);
        //{x:1, o:2}
        if(!rowMap.containsKey(ch)){
            rowMap.put(ch, 0);
        }

        rowMap.put(ch, rowMap.get(ch) + 1);

        return rowMap.get(ch) == board.getSize();

    }

    @Override
    public void undoMove(Move lastMove) {
        int row = lastMove.getCell().getRow();
        Character ch = lastMove.getPlayer().getSymbol().getSymbol();

        rowCounts.get(row).put(ch, rowCounts.get(row).get(ch) - 1);
    }
}
