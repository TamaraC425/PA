package com.tom;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private int sizeProgression;
    private String NameWinner=null;
    private final List<Player> playerList=new ArrayList<>();

    public Board getBoard() {
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

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void addPlayer(Player player)
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
        for(Player p:playerList)
        {
            new Thread(p).start();
        }
    }
}
