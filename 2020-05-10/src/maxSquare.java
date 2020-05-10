public class maxSquare {
    public static void main(String[] args) {
        int[][] matrix =
        {{0, 1, 1, 1, 0, 0, 1, 1, 0, 0},
        {0, 1, 1, 0, 1, 0, 1, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
        {0, 1, 0, 0, 0, 1, 0, 1, 1, 0},
                {0, 0, 0, 1, 1, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 0, 0, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 1, 0, 0},
                {1, 1, 1, 1, 0, 1, 0, 1, 1, 1}};

        new Solution1().findSquare(matrix);
    }

}

class Solution1 {
    public int[] findSquare(int[][] matrix) {
        int[] result = new int[3];
        int[] result1 = new int[0];
        //寻找右下角
        //记录当前元素前方的0的个数，上方0的个数，然后遍历边长
        int[][] dpUp = new int[matrix.length+1][matrix[0].length+1];
        int[][] dpLeft = new int[matrix.length+1][matrix[0].length+1];
        int lineMax = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j= 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 1)   continue;
                dpUp[i+1][j+1] = dpUp[i][j+1] + 1;
                dpLeft[i+1][j+1] = dpLeft[i+1][j] + 1;
                //遍历最大边长
                lineMax = Math.min(dpUp[i+1][j+1],dpLeft[i+1][j+1]);
                for(int k = lineMax; k >= 1; k--){
                    //判断上面的边长是否有k个长度
                    if(dpLeft[i+1-k+1][j+1] < k)   continue;
                    if(dpUp[i+1][j+1-k+1] < k)   continue;
                    if(k > result[2]){
                        result[2] = k;
                        result[1] = j - k + 1;
                        result[0] = i - k + 1;
                        break;
                    }
                }
            }
        }

        return result[2] == 0 ? result1 : result;
    }
}