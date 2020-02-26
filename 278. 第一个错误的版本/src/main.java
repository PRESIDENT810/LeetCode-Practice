public class main {
    public static void main(String args[]){
        System.out.print(new Solution278().firstBadVersion(2126753390));
    }
}

class Solution278 {
    int ans = 1702766719;
    public boolean isBadVersion(int i) {
        return i >= ans;
    }

    public int firstBadVersion(int n) {
        int low = 0;
        int high = n;
        int mid = low+(high-low)/2;

        while (low <= high) {
            if (!isBadVersion(mid)) low = mid+1;
            else high = mid-1;
            mid = low+(high-low)/2;
        }
        return low;
    }
}