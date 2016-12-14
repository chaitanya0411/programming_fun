package graph;

public class AndroidUnlockPatterns
{
    private int newCount = 0;
    
    //finds count of unlock patterns of length m to n
    public int numberOfPatterns(int m, int n)
    {
        boolean[][] numPad = new boolean[3][3];
        
        int count = 0;
        
        
        findCombinations(numPad, 0, 0, 0, m, n); // 1,3,7,9
        count += newCount * 4;
        
        newCount = 0;
        
        findCombinations(numPad, 0, 1, 0, m, n); // 2,4,6,8
        count += newCount * 4;
        
        newCount = 0;
        
        findCombinations(numPad, 1, 1, 0, m, n);//5
        count += newCount;
        
        return count;
    }
    
    private void findCombinations(boolean[][] numPad, int i, int j,
                                  int depth, int m, int n)
    {
        if(depth > n || i > 2 || i < 0 || j > 2 || j < 0 || numPad[i][j])
        {
            return;
        }
        
        depth++;
        
        if(depth >= m && depth <= n)
        {
            newCount++;
        }
        
        numPad[i][j] = true;
        
        //To be optimized
        
        //neighbors
        findCombinations(numPad, i + 1, j, depth, m, n);
        findCombinations(numPad, i - 1, j, depth, m, n);
        findCombinations(numPad, i, j + 1, depth, m, n);
        findCombinations(numPad, i, j - 1, depth, m, n);
        findCombinations(numPad, i + 1, j + 1, depth, m, n);
        findCombinations(numPad, i - 1, j - 1, depth, m, n);
        findCombinations(numPad, i - 1, j + 1, depth, m, n);
        findCombinations(numPad, i + 1, j - 1, depth, m, n);
        
        //non neighbors, not passing through
        findCombinations(numPad, i + 2, j + 1, depth, m, n);
        findCombinations(numPad, i + 2, j - 1, depth, m, n);
        findCombinations(numPad, i - 2, j + 1, depth, m, n);
        findCombinations(numPad, i - 2, j - 1, depth, m, n);
        findCombinations(numPad, i + 1, j + 2, depth, m, n);
        findCombinations(numPad, i + 1, j - 2, depth, m, n);
        findCombinations(numPad, i - 1, j + 2, depth, m, n);
        findCombinations(numPad, i - 1, j - 2, depth, m, n);
        
        //passing through
        if(i + 2 <= 2 && numPad[i + 1][j])
        {
            findCombinations(numPad, i + 2, j, depth, m, n);
        }
        
        if(i - 2 >= 0 && numPad[i - 1][j])
        {
            findCombinations(numPad, i - 2, j, depth, m, n);
        }
        
        if(j + 2 <= 2 && numPad[i][j + 1])
        {
            findCombinations(numPad, i, j + 2, depth, m, n);
        }
        
        if(j - 2 >= 0 && numPad[i][j - 1])
        {
            findCombinations(numPad, i, j - 2, depth, m, n);
        }
        
        if(i + 2 <= 2 && j + 2 <= 2 && numPad[i + 1][j + 1])
        {
            findCombinations(numPad, i + 2, j + 2, depth, m, n);
        }
        
        if(i - 2 >= 0 && j + 2 <= 2 && numPad[i - 1][j + 1])
        {
            findCombinations(numPad, i - 2, j + 2, depth, m, n);
        }
        
        if(i + 2 <= 2 && j - 2 >= 0 && numPad[i + 1][j - 1])
        {
            findCombinations(numPad, i + 2, j - 2, depth, m, n);
        }
        
        if(i - 2 >= 0 && j - 2 >= 0 && numPad[i - 1][j - 1])
        {
            findCombinations(numPad, i - 2, j - 2, depth, m, n);
        }
        
        numPad[i][j] = false;
    }
}