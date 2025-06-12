package com.solid.tictactoe.models;

import java.util.Scanner;

@lombok.Getter
@lombok.Setter
public class HumanPlayer extends Player {
    private int age;
    private int level;

    private Scanner scanner;

    public HumanPlayer(String playerName, Symbol symbol, int age, int level){
        super();
        this.age = age;
        this.level = level;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println("Ente Row for the Move");
        int row = scanner.nextInt();
        System.out.println("Enter Column for the Move");
        int column = scanner.nextInt();

        return new Move(new Cell(row, column), this);
    }
}
