package com.solid.tictactoe.models;
@lombok.Getter
@lombok.Setter
public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellStatus cellStatus;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellStatus = CellStatus.EMPTY;
    }
    public void display(){
        if(cellStatus == CellStatus.EMPTY) {
            System.out.print("| . |");
        } else if (cellStatus == CellStatus.OCCUPIED) {
            System.out.print("| " + player.getSymbol() + " |");
        }
    }
}
