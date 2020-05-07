package server;

public class Board {
private int[][] board;

    public Board() {
        board=new int[15][15];
        for(int i=0;i<15;i++)
            for(int j=0;j<15;j++)
                board[i][j]=0;

    }

    public String addPieces(Player player,int x,int y)
    {
           if(fullBoard()==true)
               return "Full board";
       if(board[x][y]!=0)
           return "Player "+player.getName()+" choose an empty square";
       else
           board[x][y]=(int)player.getId();
       return "Player "+player.getName()+" place a piece";
    }
    public boolean fullBoard()
    {
        boolean empty=false;
        for(int i=0;i<15;i++)
            for(int j=0;j<15;j++)
                 if(board[i][j]==0)
                     empty=true;
                 if(empty==true)
                     return true;
          return false;
    }
    public boolean findWinner(int x,int y)
    {
        if(findSolution(board[x][y],x,y,1,0)>=5)
            return true;
        if(findSolution(board[x][y],x,y,0,1)>=5)
            return true;
        if(findSolution(board[x][y],x,y,1,1)>=5)
            return true;
        if(findSolution(board[x][y],x,y,1,-1)>=5)
            return true;
        return false;
    }
    public int findSolution(int playerId,int x,int y,int axaX,int axaY)
    {
        int nrPieces=1;
        int row;
        int column;
        row=x+axaX;
        column=y+axaY;
        while(row>=0&&row<15&&column>=0&&column<15&&board[row][column]==playerId)
        {
            nrPieces++;
            row=row+axaX;
            column=column+axaY;
        }
        row=x-axaX;
        column=y-axaY;
        while(row>=0&&row<15&&column>=0&&column<15&&board[row][column]==playerId)
        {
            nrPieces++;
            row=row-axaX;
            column=column-axaY;
        }
        return nrPieces;
    }

}
