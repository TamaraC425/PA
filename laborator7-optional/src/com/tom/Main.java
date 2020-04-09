package com.tom;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    Game game=new Game();
        game.setBoard(new Board(16));
        game.setSizeProgression(6);
        game.addManualPlayer(new ManualPlayer("Player 2"));
        game.addRandomPlayer(new RandomPlayer("Player 1"));
        game.start();
    }
}
