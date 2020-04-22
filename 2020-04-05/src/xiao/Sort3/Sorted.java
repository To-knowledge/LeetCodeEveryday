package xiao.Sort3;

import java.util.ArrayList;
import java.util.List;

public class Sorted {
    public static void main(String[] args) {
        int[][] arr = {{1,4},{0,2},{3,5}};
        new Solution().merge(arr);
        System.out.println("jeishu");
    }
}


class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0)   return new int[0][0];
        List<int[]> result = new ArrayList<>();
        //快速排序
        quickSort(0, intervals.length - 1, intervals);

        //归并排序

        //堆排序


        //一次扫描是否合并
        result.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= result.get(result.size() - 1)[1]){
                result.get(result.size() - 1)[1] = result.get(result.size() - 1)[1] > intervals[i][1]? result.get(result.size() - 1)[1] : intervals[i][1];
            }
            else
                result.add(intervals[i]);
        }

        return result.toArray(new int[result.size()][]);
    }

    private void quickSort(int i, int j, int[][] intervals) {
        //选择开头元素轴点
        //备份开头元素，留出空位，从右向左扫描，一旦出现改变位置，再从左向右扫描，轮替进行
        if(i >= j) return;
        //引用传递，导致bug
        int a = intervals[i][0];
        int b = intervals[i][1];
        int start = i, end = j;
        boolean direction = true;
        while(start != end){
            if(direction == true) {
                if (intervals[end][0] >= a)
                    end--;
                else {
                    intervals[start][0] = intervals[end][0];
                    intervals[start][1] = intervals[end][1];
                    start++;
                    direction = false;
                }
            }
            else{
                if (intervals[start][0] <= a)
                    start++;
                else {
                    intervals[end][0] = intervals[start][0];
                    intervals[end][1] = intervals[start][1];
                    end--;
                    direction = true;
                }
            }
        }
        //将轴点归位
        intervals[start][0] = a;
        intervals[start][1] = b;
        //递归进行左边快速排序，右边快速排序
        quickSort(i, start - 1, intervals);
        quickSort(start + 1, j, intervals);
    }
}