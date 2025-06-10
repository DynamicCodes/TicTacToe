package com.solid.tictactoe.models;

@lombok.Getter
@lombok.Setter
public class Player {
    private String name;
    private PlayerType playerType;
    private Symbol symbol;

    public Player(){
        this.name = "Default Player";
        this.playerType = PlayerType.HUMAN;
        this.symbol = null;
    }

    public Player(String name, PlayerType playerType, Symbol symbol) {
        this.name = name;
        this.playerType = playerType;
        this.symbol = symbol;
    }


}
