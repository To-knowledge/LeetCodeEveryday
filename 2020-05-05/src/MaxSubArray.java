public class MaxSubArray {

}

class Solution1 {
    public int maxSubArray(int[] nums) {
        //1、线性级别的算法
        //动态规划->子序列以谁结尾为状态
        int[] dp = new int[nums.length + 1];
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            //dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            dp[i+1] = dp[i] > 0 ? dp[i] + nums[i] : nums[i];
            result = result > dp[i+1] ? result : dp[i+1];
        }

        return result;
    }

}
