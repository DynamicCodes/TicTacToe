package com.solid.tictactoe.models;
@lombok.Getter
@lombok.Setter
public class HumanPlayer extends Player {
    private int age;
    private int level;

    public HumanPlayer(String playerName, Symbol symbol, int age, int level){
        super();
        this.age = age;
        this.level = level;
    }
}
