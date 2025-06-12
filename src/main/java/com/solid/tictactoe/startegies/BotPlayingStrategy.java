package com.solid.tictactoe.startegies;

import com.solid.tictactoe.models.Board;
import com.solid.tictactoe.models.Move;
import com.solid.tictactoe.models.Player;

public interface BotPlayingStrategy {
    public Move makemove(Board board, Player player);
}
