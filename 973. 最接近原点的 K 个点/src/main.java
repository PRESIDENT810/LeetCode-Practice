import java.util.*;

class main {
    public static void main(String args[]){
        int[][] arr = {
                {89,6},
                {-39,-4},
                {-13,91},
                {97,-61},
                {1,7},
                {-66,69},
                {-51,68},
                {82,-6},
                {-21,44},{-58,-83},{-40,73},{-88,-24}};
        int K = 8;
        new Solution973().kClosest(arr, K);
    }
}

class Solution973 {
    public int[][] kClosest(int[][] points, int K) {
        int mid = -1;
        int start = 0;
        int end = points.length-1;
        while (mid != K){
            if (start >= end) break;
            mid = partition(points, start, end);
            if (mid > K) end = mid-1;
            else if (mid < K) start = mid+1;
            else break;
        }
        int[][] res = new int[K][];
        for (int i=0; i<K; i++) res[i] = points[i];
        return res;
    }

    public int partition(int[][] points, int start, int end){
        int[] pivot = points[start];
        int L = start+1;
        int R = end;
        while (true){
            while (L < R && compare(points[R], pivot) <= 0) R--;
            while (L < R && compare(points[L], pivot) >= 0) L++;
            if (L >= R) break;
            swap(points, L, R);
        }
        if (compare(points[start], points[L]) > 0) return start;
        swap(points, start, L);
        return L;
    }

    public void swap(int[][] points, int n1, int n2){
        int[] temp = points[n1];
        points[n1] = points[n2];
        points[n2] = temp;
    }

    public int compare(int[] o1, int[] o2){
        return o2[0]*o2[0]+o2[1]*o2[1]-o1[0]*o1[0]-o1[1]*o1[1];
    }
}