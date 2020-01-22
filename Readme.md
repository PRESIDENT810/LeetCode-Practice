## 3. 无重复字符的最长子串
- Case: very long String

不能使用递归（每次递归判断多一个字符的字符串），如果初始字符串太长的话会导致栈溢出

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

Java整数只支持-2147483648 (-2^31) 到 2147483647 (2^31-1) 范围内的数字

如果遇到负数时乘-1处理, 遇到-2147483648会溢出, 因为**-2147483648是一个有效的java整数，但是2147483648并不是！（溢出）**, 

(**唯一java支持某个负数，但不支持其对应相反数（正数）的情况!**)
  
Note：使用long类型避免整数溢出情况!

## 27. 移除元素
除了把不同的数字向前移动，也可以把重复的数字向后移动


## 35. 搜索插入位置
执行二分搜索时，初始时tail应该是数组长度**而不是数组长度-1**
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
常见极端情况:
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

### Gaussian Newton method:

To find the square root of target is equivalent to:

maximize f(x), where f'(x)=x^2-target

Then we can use Gaussian Newton to solve this optimization problem

x_{k+1} = x_{k} - f'(x)/f''(x)

where f'(x) = x^2-target, f''(x) = 2x 

iterate until we find one that is close enough

## 88. 合并两个有序数组
> 方法三 : 双指针 / 从后往前
直觉: 方法二已经取得了最优的时间复杂度O(n+m), 但需要使用额外空间。这是由于在从头改变nums1的值时，需要把nums1中的元素存放在其他位置。

> 如果我们从结尾开始改写 nums1 的值又会如何呢？**这里没有信息，因此不需要额外空间**。
这里的指针 p 用于追踪添加元素的位置。

This is so fuckin' brilliant


## 100. 相同的树 & 101. 对称二叉树

Visiting every node of a tree:
**Recursion: use DFS**
**Iteration: use BFS**

## 104. 二叉树的最大深度
Fuck trees, always beware of an empty tree (`Tree = []`)


## 136. 只出现一次的数字
- 如果我们对 0 和二进制位做 XOR 运算，得到的仍然是这个二进制位

    a⊕0=a
- 如果我们对相同的二进制位做 XOR 运算，返回的结果是 0

    a⊕a=0
- XOR 满足交换律和结合律

    a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
    
所以对数组中所有数字依次进行异或运算，出现两次的数字异或之后变为0，
只有唯一一个只出现一次的数字与0异或，结果仍然是这个数字

**常规算法无法解决问题时，记得考虑能否使用位运算解决问题!!!**


## 141. 环形链表
- 自己的解法：

思路：遍历链表，每次经过一个节点时，把这个节点与下一个断开，并在这个节点后面连一个“特殊节点”

如果有环：那么一路遍历到链表最后，会因为有环而遍历到之前已经遍历过的一个节点，而这个节点在之前的操作中已经把下一个连接成了“特殊节点”，所以一路遍历下去时如果遇到这个“特殊节点”，则说明出现环，反而遍历到前面的某个节点了，返回true

如果没环：那么一路遍历到最后都不会跑回到前面已经遍历过的节点上，所以不会遇到“特殊节点”，那么到结尾null的时候停止并返回false即可

那么怎么设置这个“特殊节点”呢？这个节点的作用就是说明它连接的上一个节点已经被遍历过了，因此这个“特殊节点”必须足够特殊，以便跟链表里的其它节点区分开，所以我直接把头节点当成这个特殊节点（头节点是肯定不会在后面出现的，所以肯定可以区分开）。

**缺点：破坏了链表结构...**

- 标准答案：
思路

想象一下，两名运动员以不同的速度在环形赛道上跑步会发生什么？


通过**使用具有不同速度的快、慢两个指针遍历链表**，空间复杂度可以被降低至 
O(1)。慢指针每次移动一步，而快指针每次移动两步。

如果列表中不存在环，最终快指针将会最先到达尾部，此时我们可以返回 false。

现在考虑一个环形链表，把慢指针和快指针想象成两个在环形赛道上跑步的运动员（分别称之为慢跑者与快跑者）。而快跑者最终一定会追上慢跑者。这是为什么呢？考虑下面这种情况（记作情况 A）- 假如快跑者只落后慢跑者一步，在下一次迭代中，它们就会分别跑了一步或两步并相遇。

其他情况又会怎样呢？例如，我们没有考虑快跑者在慢跑者之后两步或三步的情况。但其实不难想到，因为在下一次或者下下次迭代后，又会变成上面提到的情况 A。