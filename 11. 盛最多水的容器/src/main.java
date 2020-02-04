public class main {
    public static void main(String args[]){
        int[] arr = {2,3,4,5,18,17,6};
        System.out.print(new Solution11().maxArea(arr));
    }
}

class Solution11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        int area, l_height, r_height;

        while (left != right) {
            l_height = height[left];
            r_height = height[right];
            area = Math.min(l_height, r_height)*(right-left);
            if (area > max) max = area;
            if (l_height < r_height) left++;
            else right--;
        }
        return max;
    }
}