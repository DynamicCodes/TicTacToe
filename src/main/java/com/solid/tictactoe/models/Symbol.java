package com.solid.tictactoe.models;
@lombok.Getter
@lombok.Setter
public class Symbol {
    private Character symbol;

    public Symbol(Character symbol) {
        this.symbol = symbol;
    }
}
