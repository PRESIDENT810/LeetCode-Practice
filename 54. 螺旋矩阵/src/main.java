import java.util.*;

class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        int height = matrix.length;
        if (height == 0) return res;
        int width = matrix[0].length;
        if (width == 0) return res;

        int direction = 4; // up: 1, down: 2, left: 3, right: 4
        int x = 0;
        int y = 0;

        while (true){
            if (matrix[y][x] == Integer.MIN_VALUE) break;
            res.add(matrix[y][x]);
            matrix[y][x] = Integer.MIN_VALUE;
            if (direction == 1){
                if (y > 0 && matrix[y-1][x] != Integer.MIN_VALUE) y--; // go upward
                else { // turn right
                    x++;
                    direction = 4;
                }
            }
            else if (direction == 2){
                if (y < height-1 && matrix[y+1][x] != Integer.MIN_VALUE) y++; // go upward
                else { // turn left
                    x--;
                    direction = 3;
                }
            }
            else if (direction == 3){
                if (x > 0 && matrix[y][x-1] != Integer.MIN_VALUE) x--; // go upward
                else { // turn up
                    y--;
                    direction = 1;
                }
            }
            else if (direction == 4){
                if (x < width-1 && matrix[y][x+1] != Integer.MIN_VALUE) x++; // go upward
                else { // turn down
                    y++;
                    direction = 2;
                }
            }
            if (x<0 || x==width || y<0 || y==height) return res;
        }
        return res;
    }
}