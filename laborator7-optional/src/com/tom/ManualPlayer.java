package com.tom;

import java.io.IOException;

public class ManualPlayer extends Player implements Runnable {
    private String name;
    private Game game;
    private ArithmeticProgression arithmeticProgression;

    public ManualPlayer(String name) {
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
        return this.name;
    }
   synchronized boolean chooseToken() throws InterruptedException, IOException {
           Board board = game.getBoard();
           if (board.emptyBoard())
               return false;
           Token token = new Token();
           token = board.extractManualToken();
           arithmeticProgression.addToken(token);
           System.out.println("A ales  " + name + ' ' + token.toString());
           if (arithmeticProgression.isCompleteArithmeticProgression()) {
               game.setNameWinner(this.name);
               return true;
           }
       Thread.sleep(400);
        return false;
    }
    public void run() {
        while (true) {
            try {
                if(game.getBoard().emptyBoard()) {
                    if (game.getGameOver() == 0) {
                        this.game.setGameOver(1);
                        System.out.println("GAME OVER");
                        if (this.game.getNameWinner() != null) {
                            System.out.println("Winner " + game.getNameWinner() + arithmeticProgression.toString());
                        }
                        break;
                    }
                    else{break;}
                }
                if(game.getBoard().emptyBoard()==false&&game.getGameOver()!=1&&this.chooseToken()) {
                        this.game.setGameOver(1);
                        System.out.println("GAME OVER");
                        if (this.game.getNameWinner() != null) {
                            System.out.println("Winner " + game.getNameWinner() + arithmeticProgression.toString());
                        }
                        break;
                }
                else
                {
                    if (game.getGameOver() == 1) {
                        break;
                    }
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }

        }
    }

}
