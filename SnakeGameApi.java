package games;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeGameApi
{
    private int[][] maze;
    
    private Queue<int[]> q;
    
    private int width;
    private int height;
    
    private int[][] food;
    private int fIndex;
    private int iPos;
    private int jPos;
    
    private int score;
    
    /** @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is
        positioned at [1,1], the second is at [1,0]. */
        
    public SnakeGameApi(int width, int height, int[][] food)
    {
        this.maze = new int[height][width];
        
        maze[0][0] = 1;
        
        if(food.length > 0) maze[food[0][0]][food[0][1]] = 2;
        
        this.q = new LinkedList<int[]>();
        q.add(new int[]{0, 0});
        
        this.width = width;
        this.height = height;
        
        this.fIndex = 0;
        this.food = food;
        
        this.iPos = 0;
        this.jPos = 0;
        this.score = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    
    public int move(String direction)
    {
        int i = iPos, j = jPos;

        if(direction.equals("U"))
        {
            i--;
        }
        else if(direction.equals("L"))
        {
            j--;
        }
        else if(direction.equals("R"))
        {
            j++;
        }
        else if(direction.equals("D"))
        {
            i++;
        }
        
        if((i >= height) || (j >= width) || (i < 0) || (j < 0))
        {
            return -1;
        }
        else
        {
            iPos = i;
            jPos = j;
            
            if(maze[i][j] == 2)
            {
                score++;
                
                maze[i][j] = 1;
                
                q.add(new int[]{i, j});
                
                fIndex++;
                
                if(fIndex < food.length)
                {
                    maze[food[fIndex][0]][food[fIndex][1]] = 2;
                }
            }
            else
            {
                q.add(new int[]{i, j});
                
                int[] pos = q.remove();
                
                maze[pos[0]][pos[1]] = 0;
                
                if(maze[i][j] == 1)
                {
                    return -1; // game over
                }
                
                maze[i][j] = 1;
            }
        }
        
        return score;
    }
}
