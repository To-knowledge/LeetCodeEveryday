package Array8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array {
    public static void main(String[] args) {
        //测试一下归并排序
        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] arr1 = new int[][]{{1}};

        System.out.println(new Solution().printMatrix(arr1).toString());
    }
}

/*矩阵循环打印*/
/*递归*/
class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> array = new ArrayList<>();

        /*打印第几圈以内的*/
        printMatrix(array, matrix, 0, matrix.length, 0, matrix[0].length);


        int[] res = new int[array.size()];

        for(int i = 0; i < array.size(); i++){
            res[i] = array.get(i);
        }

        return array;
    }

    private void printMatrix(ArrayList<Integer> array, int[][] matrix, int rowBegin, int rowEnd, int lineBegin, int lineEnd){
        //递归基判断
        if(rowBegin >= rowEnd || lineBegin >= lineEnd)  return;

        /*非常重要*/
        if(rowEnd == rowBegin + 1){
            for(int i = lineBegin; i < lineEnd; i++)
                array.add(matrix[rowBegin][i]);
            return;
        }

        if(lineEnd == lineBegin + 1){
            for(int i = rowBegin; i < rowEnd; i++)
                array.add(matrix[i][lineBegin]);
            return;
        }

        //打印主体
        for(int i = lineBegin; i < lineEnd; i++)
            array.add(matrix[rowBegin][i]);
        for(int i = rowBegin + 1; i < rowEnd; i++)
            array.add(matrix[i][lineEnd - 1]);
        for(int i = lineEnd - 2; i >= lineBegin; i--)
            array.add(matrix[rowEnd - 1][i]);
        for(int i = rowEnd - 2; i > rowBegin; i--)
            array.add(matrix[i][lineBegin]);

        printMatrix(array, matrix, rowBegin + 1, rowEnd - 1, lineBegin + 1, lineEnd - 1);
    }
}

