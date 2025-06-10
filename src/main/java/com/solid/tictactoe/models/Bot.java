package com.solid.tictactoe.models;
@lombok.Getter
@lombok.Setter
public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(String PlayerName, BotDifficultyLevel botDifficultyLevel) {
        super(PlayerName, PlayerType.BOT, new Symbol('B'));
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
