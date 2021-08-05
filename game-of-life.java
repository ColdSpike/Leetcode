/*
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
1) Any live cell with fewer than two live neighbors dies as if caused by under-population.
2) Any live cell with two or three live neighbors lives on to the next generation.
3) Any live cell with more than three live neighbors dies, as if by over-population.
4) Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
Given the current state of the m x n grid board, return the next state.

Example 1:
Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

Example 2:
Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]
 
Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.

Follow up:
1) Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
2) In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?
*/

class Solution {
    public void gameOfLife(int[][] board) {
        findNextState(board);
        adjustStates(board);
    }
    
    private void findNextState(int[][] board) {
        for(int row=0; row < board.length; row++){
            for(int col=0; col < board[row].length; col++){
                int aliveNeighbours = findAliveNeighbours(board, row, col);
                if(board[row][col] == 1 && (aliveNeighbours < 2 || aliveNeighbours > 3))
                    board[row][col] = -1;
                else if(board[row][col] == 0 && aliveNeighbours == 3)
                    board[row][col] = 2;
            }
        }
    }
    
    private void adjustStates(int[][] board) {
        for(int row=0; row < board.length; row++){
            for(int col=0; col < board[row].length; col++){
                if(board[row][col] == -1)
                    board[row][col] = 0;
                else if(board[row][col] == 2)
                    board[row][col] = 1;
            }
        }
    }
    
    private int findAliveNeighbours(int[][] board, int row, int col) {
        int aliveCount = 0;
        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                if(i==0 && j==0) continue;
                
                int nxtRow = row + i, nxtCol = col + j;
                if(nxtRow >= board.length || nxtRow < 0 || nxtCol >= board[row].length || nxtCol < 0) continue;
                
                if(board[nxtRow][nxtCol] == 1 || board[nxtRow][nxtCol] == -1) 
                    aliveCount++;
            }
        }
        return aliveCount;
    }
}
