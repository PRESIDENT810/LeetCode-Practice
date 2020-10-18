class Solution64 {
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        for (int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] = grid[i][j]+grid[i][j-1];
                else if (j == 0) grid[i][j] = grid[i][j]+grid[i-1][j];
                else{
                    grid[i][j] = grid[i][j]+Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[height-1][width-1];
    }
}