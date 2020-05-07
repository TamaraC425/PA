package server;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private int activePlayer;
    private boolean gameOver=false;
    private final List<Player> playerList=new ArrayList<>();

    public Game() {
        this.activePlayer=0;
    }

    public Board getBoard() {
        return board;
    }

    public int getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(int activePlayer) {
        this.activePlayer = activePlayer;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void addPlayer(Player player)
    {
        playerList.add(player);
        player.setGame(this);
    }
    public void finishGame()
    {
        gameOver=true;
    }


    @Override
    public String toString() {
        return "Game{" +
                "board=" + board +
                ", playerList=" + playerList +
                '}';
    }
}
