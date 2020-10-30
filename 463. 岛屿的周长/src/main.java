class main {
    public static void main(String args[]){

    }
}

class Solution463 {
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int sum = 0;

        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                // if island, +4
                if (grid[i][j] == 1) {
                    sum += 4;
                    // if adjacent to land, -2
                    if (i-1 >= 0 && grid[i-1][j] == 1) sum -= 2;
                    // if (i+1 < grid.length && grid[i+1][j] == 1) sum -= 2;
                    if (j-1 >= 0 && grid[i][j-1] == 1) sum -= 2;
                    // if (j+1 < grid[0].length && grid[i][j+1] == 1) sum -= 2;
                }
                // System.out.printf("i=%d, j=%d, sum=%d\n", i, j, sum);
            }
        }
        return sum;
    }
}