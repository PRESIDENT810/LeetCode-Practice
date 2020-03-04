import java.util.*;

public class main {
    public static void main(String args[]){
        int[][] arr = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.print(new Solution994().orangesRotting(arr));
    }
}

class Node{
    int i, j;
    int date;
    public Node(int i, int j, int date){this.i = i; this.j = j; this.date = date;}
}

class Solution994 {
    public int orangesRotting(int[][] grid) {
        Queue<Node> rotten = new LinkedList<>();
        int fresh = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j] == 2) rotten.add(new Node(i,j,0));
                if (grid[i][j] == 1) fresh++;
            }
        }

        int max_date = 0;

        while (!rotten.isEmpty()){
            Node source = rotten.remove();
            int i = source.i;
            int j = source.j;
            int date = source.date;
            max_date = max_date > date ? max_date : date;
            try {if (grid[i-1][j] == 1) {grid[i-1][j] = 2; fresh--; rotten.add(new Node(i-1, j, date+1));}} catch (java.lang.ArrayIndexOutOfBoundsException e){};
            try {if (grid[i+1][j] == 1) {grid[i+1][j] = 2; fresh--; rotten.add(new Node(i+1, j, date+1));}} catch (java.lang.ArrayIndexOutOfBoundsException e){};
            try {if (grid[i][j+1] == 1) {grid[i][j+1] = 2; fresh--; rotten.add(new Node(i, j+1, date+1));}} catch (java.lang.ArrayIndexOutOfBoundsException e){};
            try {if (grid[i][j-1] == 1) {grid[i][j-1] = 2; fresh--; rotten.add(new Node(i, j-1, date+1));}} catch (java.lang.ArrayIndexOutOfBoundsException e){};
        }

        return fresh == 0 ? max_date : -1;
    }
}