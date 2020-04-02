package com.tom;

import java.util.ArrayList;
import java.util.List;

public class Player extends Thread{
    private String name;
     private Game game;
     private ArithmeticProgression arithmeticProgression;

    public Player(String name) {
        this.name = name;
    }
    public ArithmeticProgression getArithmeticProgression() {
        return arithmeticProgression;
    }

    public void setArithmeticProgression(int value) {
        this.arithmeticProgression = new ArithmeticProgression(game.getSizeProgression());
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    @Override
    public String toString() {
        return name;
    }

    private boolean chooseToken()throws InterruptedException
    {
        Board board=game.getBoard();
        if(board.emptyBoard())
            return false;
        Token token=new Token();
        token=board.extractToken();
        arithmeticProgression.addToken(token);
        System.out.println("A ales jucatorul "+name+token.toString());
        Thread.sleep(400);
        if(arithmeticProgression.isCompleteArithmeticProgression()) {
            game.setNameWinner(this.getName());
            return true;
        }
        return false;

    }
    @Override
    public void run() {
        while (true) {
            try {
                if (chooseToken()) {
                    System.out.println("Winner "+game.getNameWinner()+arithmeticProgression.toString());
                    break;
                }
                if(game.getBoard().emptyBoard()) {
                break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}




