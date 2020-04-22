package xiao.BitOperation6;

public class BitOperation {
    public static void main(String[] args) {
        System.out.println(new Solution().NumberOf1(1));
    }
}

/*1的个数*/

class Solution {
    public int NumberOf1(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            res = (n & 1) == 1 ? res + 1 : res;
            n = n >> 1;
        }
        return res;
    }
}
