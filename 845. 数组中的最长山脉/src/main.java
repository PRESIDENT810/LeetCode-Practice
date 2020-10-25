class main {
    public static void main(String args[]){
        int[] arr = {0,1,0,0,1,0,0,1,1,0,0,0,1,1,0,1,0,1,0,1,0,0,0,1,0,0,1,1,0,1,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,0,0,1,1,0,0,1,1,1,1,0,0,0,1,0,0,1,1,0,0,0,1,0,0,1,1,0,0,0,0,1,0,0,1,1,1,1,1,1,1,0,1,1,0,1,1,1,0,0,0,1,0,1,1};
        int res = new Solution845().longestMountain(arr);
        System.out.print(res);
    }
}

class Solution845 {
    public int longestMountain(int[] A) {
        if (A.length < 3) return 0;
        int ptr1 = 0;
        int ptr2 = 0;
        int last = A[0];
        int max = 0;
        boolean ascend = false;
        boolean descend = false;
        while (ptr2 != A.length){
            if (ascend && descend){ // already reached peek and now descending
                if (A[ptr2] > last){ // try a new mountain
                    max = max > ptr2-ptr1 ? max : ptr2-ptr1;
                    ascend = true;
                    descend = false;
                    ptr1 = ptr2-1;
                }
                else if (A[ptr2] == last){
                    max = max > ptr2-ptr1 ? max : ptr2-ptr1;
                    ascend = false;
                    descend = false;
                    ptr1 = ptr2;
                }
                else{ // this mountain not end yet

                }
            }
            else if (ascend){ // still ascending and not reached a peek yet
                if (A[ptr2] > last){ // continue looking for a peek

                }
                else if (A[ptr2] == last){ // same height, so move on with no ascend / descend
                    max = max > ptr2-ptr1 ? max : ptr2-ptr1;
                    ptr1 = ptr2;
                    ascend = false;
                    descend = false;
                }
                else{ // last one is peek, start to descend
                    descend = true;
                }
            }
            else if (descend){ // no ascend but only descend, not possible

            }
            else{ // no ascend and no descend
                if (ptr1 != ptr2){
                    if (A[ptr1] < A[ptr2]){
                        ascend = true;
                    }
                    else{
                        ptr1 = ptr2;
                    }
                }
            }
            last = A[ptr2];
            ptr2++;
        }
        if (ascend && descend) max = max > ptr2-ptr1 ? max : ptr2-ptr1;
        return max > 2 ? max : 0;
    }
}