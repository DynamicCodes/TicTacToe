package com.solid.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

@lombok.Getter
@lombok.Setter
public class Board {
    private int size;
    private List<List<Cell>> grid;

    public Board(int size){
        this.size = size;
        this.grid = new ArrayList<>();
        buildGrid();
    }
    private void buildGrid(){
        for(int i=0; i<size; i++){
            grid.add(new ArrayList<>());
            for(int j=0; j<size; j++){
                grid.get(i).add(new Cell(i ,j));
            }
        }
    }


    public void display(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                grid.get(i).get(j).display();
            }
            System.out.println();
        }
    }
}
