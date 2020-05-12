# LeetCodeEveryday
for interest also for job.
(非特别说明，以下题解皆为原创)
### 寻找数组中仅出现一次的两个数（2020-04-28）
[leetcode题解](https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/can-zhao-yi-huo-jie-jue-fang-an-de-javaban-ben-by-/)

### 查找山脉数组（2020-04-29）
[leetcode题解](https://leetcode-cn.com/problems/find-in-mountain-array/solution/javashuang-bai-fen-bai-tong-guo-shi-jian-fu-za-du-/)

### 快乐数判断（2020-04-30）
[leetcode题解](https://leetcode-cn.com/problems/happy-number/solution/javasan-lie-biao-zuo-xun-huan-jian-ce-by-balancex-/)

### 合并两个有序链表（2020-05-01）
链表迭代中留意虚拟头节点的用法

### 最长无重复子串（2020-05-05）
双指针+散列表查重并记录索引

### 最大子序列和（2020-05-05）
DP状态选择以哪个索引结尾，dp[i] = max(dp[i-1] + nums[i], nums[i])

### 最低票价（2020-05-06）
[leetcode题解](https://leetcode-cn.com/problems/minimum-cost-for-tickets/solution/zhuang-tai-zhuan-yi-fang-cheng-zi-di-xiang-shang-s/)

### 最大正方形（2020-05-08）
[leetcode题解](https://leetcode-cn.com/problems/maximal-square/solution/san-ge-dpshu-zu-dong-tai-gui-hua-javashi-xian-by-b/)

### 字典树查单词频率（2020-05-10）
注意字典树节点的定义
```java
class TrieNode{
    int cnt;
    //只定义了26个引用
    TrieNode[] son = new TrieNode[26];
    //真正用到某一结点时，还需要son[i] = new TrieNode();定义实体
    
    public TrieNode(){
        this.cnt = 0;    
    }
}
```

### KMP字符串匹配高效算法
模式串的next表（核心）
```java
public class KMP_Test {
    public static void main(String[] args) {
        String pattern = new String("bc");
        String text = new String("abcd");
        int result = new KMP().indexOf(pattern, text);
        System.out.println(result);
    }
}

class KMP {
    public int indexOf(String pattern, String text){
        if(pattern == null || text == null) return -1;
        int pPointer = 0;
        int tPointer = 0;
        //记录模式串与文本串的长度，用于限定pPointer、tPointer的活动范围
        int pLength = pattern.length();
        int tLength = text.length();
        if(pLength == 0 || tLength < pLength) return -1;
        //生成pattern的next数组
        int[] next = next(pattern);
        //开始进行匹配
        while(tPointer < tLength - pLength + 1){
            //pPointer = -1是一个哨兵，该设计有两点：1、生成next时兼容设计；2、-1只能进行if里面的操作
            if(pPointer == -1 || pattern.charAt(pPointer) == text.charAt(tPointer)){
                pPointer++;
                tPointer++;
                //全部匹配成功时
                if(pPointer == pLength) return tPointer - pLength;
            }else{
                //匹配失败时，模式串向右移动pPointer - next[pPointer]
                pPointer = next[pPointer];
            }
        }
        //匹配不成功返回-1
        return -1;
    }

    private int[] next(String pattern){
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int n = -1;
        int i = 0;
        while(i < next.length - 1){
            if(n == -1 || pattern.charAt(i) == pattern.charAt(n)){
                next[i + 1] = n + 1;
                i++;
                n++;
            }else{
                n = next[n];
            }
        }
        return next;
    }
}

```

### 最小栈（2020-05-12）
注意类的equals与==的区别

对于Integer类，它重写了Object的equals方法，直接比较的是内容