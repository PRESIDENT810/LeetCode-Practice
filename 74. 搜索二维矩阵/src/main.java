class main {
    public static void main(String args[]){
        int[][] matrix = {{1}};
        new Solution74().searchMatrix(matrix, 0);
    }

}

class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        // find which row
        int L_row = 0;
        int R_row = matrix.length-1;
        int M_row = (L_row+R_row)/2;
        while (L_row < R_row){
            if (matrix[M_row][0] > target){ // go up
                R_row = M_row;
            }
            else if (matrix[M_row][0] < target) { // go down
                L_row = M_row+1;
            }
            else return true;
            M_row = (L_row+R_row)/2;
        }
        M_row = (L_row+R_row)/2;
        int target_row;
        if (matrix[M_row][0] < target) target_row = M_row;
        else if (matrix[M_row][0] > target){
            target_row = M_row-1;
            if (target_row < 0) return false;
        }
        else return true;
        // find which column
        int L_col = 0;
        int R_col = matrix[0].length-1;
        int M_col = (L_col+R_col)/2;
        while (L_col < R_col){
            if (matrix[target_row][M_col] > target){ // go left
                R_col = M_col;
            }
            else if (matrix[target_row][M_col] < target) { // go right
                L_col = M_col+1;
            }
            else return true;
            M_col = (L_col+R_col)/2;
        }
        return matrix[target_row][M_col] == target;
    }
}