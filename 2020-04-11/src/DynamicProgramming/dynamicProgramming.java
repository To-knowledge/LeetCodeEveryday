package DynamicProgramming;

public class dynamicProgramming {

    public static void main(String[] args) {

    }
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text2.length() + 1][text1.length() + 1];
        //确定初始值
        for(int i = 0; i < text1.length() + 1; i++)
            dp[0][i] = 0;
        for(int j = 0; j < text2.length() + 1; j++)
            dp[j][0] = 0;

        //状态转移方程，自底向上
        for(int j = 1; j < text2.length() + 1; j++)
            for(int i = 1; i < text1.length() + 1; i++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[j][i] = dp[j-1][i-1] + 1;
                else
                    dp[j][i] = dp[j][i-1] > dp[j-1][i] ? dp[j][i-1] : dp[j-1][i];
            }

        return dp[text2.length()][text1.length()];
    }

}


