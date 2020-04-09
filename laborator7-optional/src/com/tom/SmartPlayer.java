package com.tom;

public class SmartPlayer extends Player implements  Runnable{

    private String name;
    private Game game;
    private ArithmeticProgression arithmeticProgression;

    public SmartPlayer(String name) {
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
    synchronized boolean chooseToken()throws InterruptedException
    {
        Board board=game.getBoard();
        if(board.emptyBoard())
            return false;
        Token token=new Token();
        token=board.extractSmartToken();
        arithmeticProgression.addToken(token);
        System.out.println("A ales  "+name+' '+token.toString());
        Thread.sleep(400);
        if(arithmeticProgression.isCompleteArithmeticProgression()) {
            game.setNameWinner(this.getName());
            return true;
        }
        return false;
    }
    public void run() {
        while (true) {
            try {
                if(game.getBoard().emptyBoard()) {
                    System.out.println("GAME OVER");
                    break;
                }
                if (chooseToken()) {
                    System.out.println("Winner "+game.getNameWinner()+arithmeticProgression.toString());
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
