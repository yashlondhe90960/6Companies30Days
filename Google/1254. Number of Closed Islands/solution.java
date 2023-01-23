class Solution {

    int ROW;
    int COL;

    boolean isOutOfBounds(int row, int col){
        return row < 0 || row >= ROW || col < 0 || col >= COL;
    }

    void removeLandAtBoundary(int[][] grid, int row, int col){
        if(isOutOfBounds(row, col) || grid[row][col] != 0) return;

        grid[row][col] = -1;

        removeLandAtBoundary(grid, row - 1, col);
        removeLandAtBoundary(grid, row + 1, col);
        removeLandAtBoundary(grid, row, col - 1);
        removeLandAtBoundary(grid, row, col + 1);
    }

    void numberOfClosedIsland(int[][] grid, int row, int col){
        if(isOutOfBounds(row, col) || grid[row][col] != 0) return;

        grid[row][col] = -1;

        numberOfClosedIsland(grid, row - 1, col);
        numberOfClosedIsland(grid, row + 1, col);
        numberOfClosedIsland(grid, row, col - 1);
        numberOfClosedIsland(grid, row, col + 1);
    }

    public int closedIsland(int[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;

        int LAND = 0;

        for(int r = 0; r < ROW; r++){
            for(int c = 0; c < COL; c++){
                if(grid[r][c] == LAND
                && ((r == 0 || r == ROW - 1)
                || (c == 0 || c == COL - 1))){
                    removeLandAtBoundary(grid, r, c);
                }
            }
        }

        //number of island that are closed in water
        int island = 0;
        for(int r = 0; r < ROW; r++){
            for(int c = 0; c < COL; c++){
                if(grid[r][c] == LAND){
                    island++;
                    numberOfClosedIsland(grid, r, c);
                }
            }
        }
        return island;
    }
}