package xiao.每日一题;
//编辑距离
public class EditDistance {
    public static void main(String[] args) {
        new Solution().minDistance("","");
    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        //空指针处理
        /*if(word1 == null && word2 == null) return 0;
        if(word1 == null)   return word2.length();
        if(word2 == null)   return word1.length();*/

        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        //初始条件
        for(int i = 1; i < n; i++)
            dp[0][i] = dp[0][i-1] + 1;
        for(int j = 1; j < m; j++)
            dp[j][0] = dp[j-1][0] + 1;

        //状态方程
        for(int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i - 1][ j - 1];
                else
                    dp[i][j] = min(dp[i-1][j-1], dp[i][j-1],dp[i-1][j]) + 1;
            }
        }
        return dp[m][n];
    }

    private int min(int a ,int b, int c){
        return a < (b < c ? b : c) ?  a : (b < c ? b : c);
    }
}
