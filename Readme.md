## 3. 无重复字符的最长子串
- Case: very long String

Cannot use recursion (each recursion with 1 less character), since the String is so fuckin' long, using recursion leads to **stack overflow**

Standard answer:
```java
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
```  

## 7. 整数反转
- Case: -2147483648

Java integer only support number from -2147483648 (-2^31) to 2147483647 (2^31-1).

If you want to times -1 when negative, doing this leads to an error, since **-2147483648 is a valid java integer but 2147483648 is not (overflow)**, 

(**The only case that java supports a negative number, but not its corresponding positive number !**)
  
Note: take care when handling integer overflow cases!

## 27. 移除元素
Apart from moving different elements forward, one can also move duplicate elements afterwords