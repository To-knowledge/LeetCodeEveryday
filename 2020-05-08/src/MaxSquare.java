public class MaxSquare {

    public static void main(String[] args) {
        char[][] arr = new char[][]{{'1','0','1','0','0'},
                                {'1','0','1','1','1'},
                                {'1','1','1','1','1'},
                                {'1','0','0','1','0'}};

        new Solution().maximalSquare(arr);

    }
}

class Solution {
    public int maximalSquare(char[][] matrix) {
        //最大正方形
        //定义三个dp二维数组
        //1、用来记录当前元素与其上面连续1的个数
        int[][] dpUp = new int[matrix.length+1][matrix[0].length+1];
        //2、用来记录当前元素与其左面连续1的个数
        int[][] dpLeft = new int[matrix.length+1][matrix[0].length+1];
        //3、用来记录以当前元素为右角可构成的最大正方形边长
        int[][] dpSqure = new int[matrix.length+1][matrix[0].length+1];
        int result = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                dpUp[i+1][j+1] = matrix[i][j] == '0' ? 0 : dpUp[i][j+1] + 1;
                dpLeft[i+1][j+1] = matrix[i][j] == '0' ? 0 : dpLeft[i+1][j] + 1;
                dpSqure[i+1][j+1] = matrix[i][j] == '0' ? 0 : Math.min(dpUp[i][j+1],dpLeft[i+1][j],dpSqure[i][j]) + 1;                                                            Math.min(dpLeft[i+1][j], dpSqure[i][j]));
                result = dpSqure[i+1][j+1] > result ? dpSqure[i+1][j+1] : result;
            }
        }

        return result*result;
    }
}
