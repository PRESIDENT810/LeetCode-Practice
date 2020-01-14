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

## 35. 搜索插入位置
When doing binary search, at first the tail should be the length of the array, **not the length-1**
```java
        int head = 0;
        int tail = nums.length; // not "nums.length-1"
        int mid = (int) (head+tail)/2;;

```

## 38. 外观数列
It saves more time when appending string if you use StringBuilder, instead of string concentration
```java
        StringBuilder result = new StringBuilder();
        ...
        result.append(generate(cnt, last_digit));
```
this is much faster than
```java
        String result = new String();
        ...
        result = result+generate(cnt, last_digit);
```

## 53 最大字序和
Common extreme case:
- Array with only one element
- Empty array
- `Integer.MAX_VALUE/MIN_VALUE`

## 58. 最后一个单词的长度
Case: "a "

...fuck, I didn't expect space at the end

Case: " "

...fuck, I didn't expect only space either

Case: "   "

... fuck, fuck, fuck

Case: "a "

... fuck this shit

## 69. x 的平方根
**Use long datatype to avoid integer overflow issue**

Since the result keeps only integer part (left), when doing binary search, mid point should use left mid as well 

## 88. 合并两个有序数组
> 方法三 : 双指针 / 从后往前
直觉: 方法二已经取得了最优的时间复杂度O(n+m), 但需要使用额外空间。这是由于在从头改变nums1的值时，需要把nums1中的元素存放在其他位置。

> 如果我们从结尾开始改写 nums1 的值又会如何呢？这里没有信息，因此不需要额外空间。
这里的指针 p 用于追踪添加元素的位置。

This is so fuckin' brilliant