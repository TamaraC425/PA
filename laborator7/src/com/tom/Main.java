package com.tom;

public class Main {

    public static void main(String[] args) {
	    Game game=new Game();
        game.setBoard(new Board(15));
        game.setSizeProgression(6);
	    game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.start();
    }
}
