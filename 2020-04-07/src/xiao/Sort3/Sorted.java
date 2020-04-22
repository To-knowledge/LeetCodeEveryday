package xiao.Sort3;

import java.util.Arrays;

public class Sorted {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};

        new Solution().reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class Solution {
    public void reOrderArray(int [] array) {
        //冒泡排序
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - 1 - i; j++){
                if(array[j] % 2 < array[j+1] % 2)
                    swap(j, j + 1, array );
            }
        }
    }

    private void swap(int a, int b, int[] array){
        int temp = array[a];
        array[a] = array[b]; array[b] = temp;
    }
}