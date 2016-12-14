//https://en.wikipedia.org/wiki/Conway's_Game_of_Life

package games;
public class GameOfLife
{    
    public void gameOfLife(int[][] board)
    {
        if(board.length > 0)
        {
            int count;
            int liveNeighbors;
            do
            {
                count = 0;
                for(int i = 0; i < board.length; i++)
                {
                    for(int j = 0; j < board[0].length; j++)
                    {
                        liveNeighbors = calculateNeighborValues(i, j, board);
                        
                        if(((board[i][j] & 1) == 1) &&
                            (liveNeighbors == 2 || liveNeighbors == 3))
                        {
                            board[i][j] = 3;//11
                            count++;
                        }
                        else if(board[i][j] == 0 && liveNeighbors == 3)
                        {
                            board[i][j] = 2;//10
                            count++;
                        }
                    }
                }
                
                for(int i = 0; i < board.length; i++)
                {
                    for(int j = 0; j < board[0].length; j++)
                    {
                        board[i][j] = board[i][j] >> 1;
                    }
                }
                
                printBoard(board, board.length, board[0].length);
                
            }while(count > 0);
        }
        
    }
    
    private void printBoard(int[][] matrix, int m, int n)
    {
        for(int i = 0; i < m; i++)
        {
            String line = "";
            for(int j = 0; j < n; j++)
            {
                line += matrix[i][j] + " ";
            }
            System.out.println(line);
        }
    }
    
    //This is not optimal! Trying to find another way to do this!
    private int calculateNeighborValues(int i, int j, int[][] board)
    {
        int liveNeighbors = 0;

        if(i - 1 >= 0)
        {
            if((board[i - 1][j] & 1) == 1)
            {
                liveNeighbors++;
            }
        }
        
        if(i + 1 <= board.length - 1)
        {
            if((board[i + 1][j] & 1) == 1)
            {
                liveNeighbors++;
            }
        }
        
        if(j - 1 >= 0)
        {
            if((board[i][j - 1]  & 1) == 1)
            {
                liveNeighbors++;
            }
        }
        
        if(j + 1 <= board[0].length - 1)
        {
            if((board[i][j + 1] & 1) == 1)
            {
                liveNeighbors++;
            }
        }
        
        if(i + 1 <= board.length - 1 && j + 1 <= board[0].length - 1)
        {
            if((board[i + 1][j + 1] & 1) == 1)
            {
                liveNeighbors++;
            }
        }
        
        if(i - 1 >= 0 && j + 1 <= board[0].length - 1)
        {
            if((board[i - 1][j + 1] & 1) == 1)
            {
                liveNeighbors++;
            }
        }
        
        if(i + 1 <= board.length - 1 && j - 1 >= 0)
        {
            if((board[i + 1][j - 1] & 1) == 1)
            {
                liveNeighbors++;
            }
        }
        
        if(i - 1 >= 0 && j - 1 >= 0)
        {
            if((board[i - 1][j - 1] & 1) == 1)
            {
                liveNeighbors++;
            }
        }
        
        return liveNeighbors;
    }
}