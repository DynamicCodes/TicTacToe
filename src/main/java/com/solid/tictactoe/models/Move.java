package com.solid.tictactoe.models;
@lombok.Getter
@lombok.Setter
public class Move {
    private Cell cell;
    private Player player;

    public Move(Cell cell, Player player) {
        this.cell = cell;
        this.player = player;
    }
}
