package com.solid.tictactoe.startegies;

import com.solid.tictactoe.models.Board;
import com.solid.tictactoe.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
