package com.tom;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private int sizeProgression;
    private String NameWinner;
    private int activePlayer=0;
    private int gameOver=0;
    private final List<Player> playerList=new ArrayList<>();

    public synchronized Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getSizeProgression() {
        return sizeProgression;
    }

    public void setSizeProgression(int sizeProgression) {
        this.sizeProgression = sizeProgression;
    }

    public int getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(int activePlayer) {
        this.activePlayer = activePlayer;
    }

    public int getGameOver() {
        return gameOver;
    }

    public void setGameOver(int gameOver) {
        this.gameOver = gameOver;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
    public void addRandomPlayer(RandomPlayer player)
    {
        playerList.add(player);
        player.setGame(this);
        player.setArithmeticProgression(this.getSizeProgression());
    }
    public void addManualPlayer(ManualPlayer player)
    {
        playerList.add(player);
        player.setGame(this);
        player.setArithmeticProgression(this.getSizeProgression());
    }
    public void addSmartPlayer(SmartPlayer player)
    {
        playerList.add(player);
        player.setGame(this);
        player.setArithmeticProgression(this.getSizeProgression());
    }
    public String getNameWinner() {
        return NameWinner;
    }

    public synchronized void setNameWinner(String nameWinner) {
        if(this.NameWinner == null)
           NameWinner = nameWinner;
    }

    public void start()
    {
        long startTime = System.currentTimeMillis();
       Timekeeper time=new Timekeeper(startTime,20000); /// daca vrem ca jocul sa se termine dupa ce expira timpul
        time.start();
        for(Player p:playerList)
        {
            new Thread(p).start();
        }
    }
}
