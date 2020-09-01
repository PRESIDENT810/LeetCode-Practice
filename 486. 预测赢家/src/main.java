class main {
    public static void main(String args[]){
        int[] nums = {1,5,2,4,6};
        new Solution486().PredictTheWinner(nums);
    }
}

class Solution486 {
    public int[][] max; // maximum profit given nums[i:j]
    public int[][] choice; // choose left (0) or right(1) given nums[i:j]

    public boolean PredictTheWinner(int[] nums) {
        if (nums.length < 3) return true;
        int len = nums.length;
        this.max = new int[len][len];
        this.choice = new int[len][len];
        // fill diagonal elements
        for (int i=0; i<len; i++){
            this.max[i][i] = nums[i];
            this.choice[i][i] = 0;
        }
        // fill sub-diagonal elements
        for (int i=0; i<len-1; i++){
            if (this.max[i][i] > this.max[i+1][i+1]){ // choose L
                this.max[i][i+1] = this.max[i][i];
                this.choice[i][i+1] = 0;
            }
            else{
                this.max[i][i+1] = this.max[i+1][i+1];
                this.choice[i][i+1] = 1;
            }
        }
        int res_L, res_R;
        // fill rest elements
        for (int n=0; n<len-2; n++){
            for (int i=0; i<len-2-n; i++){
                int j = i+2+n; // compute maximum profit given nums[i:j]
                // try left
                if (choice[i+1][j] == 0){ // opponent choose left element
                    res_L = this.max[i+2][j]+nums[i];
                }
                else{ // opponent choose right element
                    res_L = this.max[i+1][j-1]+nums[i];
                }
                // try right
                if (choice[i][j-1] == 0){ // opponent choose left element
                    if (choice[i+1][j] == 0) res_R = res_L;
                    else res_R = this.max[i+1][j-1]+nums[j];
                }
                else{ // opponent choose right element
                    res_R = this.max[i][j-2]+nums[j];
                }
                if (res_L >= res_R){
                    this.choice[i][j] = 0;
                    this.max[i][j] = res_L;
                }
                else{
                    this.choice[i][j] = 1;
                    this.max[i][j] = res_R;
                }
            }
        }
        // determine who is the winner
        int P1 = this.max[0][len-1];
        int P2;
        if (this.choice[0][len-1] == 0) P2 = this.max[1][len-1];
        else P2 = this.max[0][len-2];
        return P1 >= P2;
    }
}
