/*
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard 
 * such that no two queens attack each other. Given an integer n, program prints
 * all distinct solutions to the n-queens puzzle.
 */

import java.util.*;

public class NQueens
{
    public void solveNQueens(int n)
    {
        traverse(new int[n][n], 0, n);
    }

    private void traverse(int[][] matrix, int depth, int n)
    {
        if(depth == n)
        {
            printMatrix(matrix, n);
            System.out.println("");
            return;
        }

        for(int j = 0; j < n; j++)
        {
            if(check(matrix, depth, j, n))
            {
                matrix[depth][j] = 1;
                traverse(matrix, depth + 1, n);
                matrix[depth][j] = 0;
            }
        }
    }

    private boolean check(int[][] matrix, int i, int j, int n)
    {
        for(int p = 0; p < i; p++)
        {
            for(int q = 0; q < n; q++)
            {
                if(matrix[p][q] == 1)
                {
                    if(q == j || (Math.abs(p - i) == Math.abs(q - j)))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void printMatrix(int[][] matrix, int n)
    {
        for(int i = 0; i < n; i++)
        {
            String row = "";
            for(int j = 0; j < n; j++)
            {
                row += matrix[i][j] + " ";
            }
            System.out.println(row);
        }
    }

}
