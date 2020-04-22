package xiao.Array8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array {
    public static void main(String[] args) {
        //测试一下归并排序
        int[] arr = new int[]{-1,0,1,2,-1,-4};

        new Solution().divideAndMerge(arr);
        new Solution().threeSum(arr);
        System.out.println(Arrays.toString(arr));
    }
}

/*三数之和等于零*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return new ArrayList<List<Integer>>();;
        //对数组进行排序
        //此处采用归并排序
        divideAndMerge(nums);
        int point1 = 0, point2 = 0;
        //确定满足解的最小的一个元素，通过双指针寻找剩下两个元素
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> buffer;
        for(int i = 0; i < nums.length - 2; i++){
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            if(nums[i] > 0) break;
            point1 = i + 1;
            point2 = nums.length - 1;
            while(point1 < point2){
                if(nums[point1] + nums[point2] + nums[i] == 0){
                    buffer = new ArrayList<>();
                    buffer.add(nums[i]);
                    buffer.add(nums[point1]);
                    buffer.add(nums[point2]);
                    res.add(buffer);
                    point1++;
                    while(nums[point1] == nums[point1 - 1] && point1 < point2)  point1++;
                    point2--;
                }
                else if(nums[point1] + nums[point2] + nums[i] > 0){
                    point2--;
                }
                else
                    point1++;
            }

        }
        return res;
    }

    public void divideAndMerge(int[] nums){
        divideAndMerge(nums, 0, nums.length);
    }

    private void divideAndMerge(int[] nums, int begin, int end){
        //递归基
        if(end - begin == 1) return;
        //先分,分的时候，选择左闭右开
        divideAndMerge(nums, begin, (begin + end) >> 1);
        divideAndMerge(nums, (begin + end) >> 1, end);
        //再整体和
        int point1 = 0, point2 = (begin + end) >> 1;
        int point3 = begin;
        //和的过程中需要开辟一段新的空间，用来备份左半部分
        int[] tmp = new int[((begin + end) >> 1) - begin];
        for(int i = 0; i < tmp.length; i++)
            tmp[i] = nums[begin + i];
        while(point1 < (((begin + end) >> 1) - begin) && point2 < end){
            nums[point3++] = nums[point2] < tmp[point1] ? nums[point2++] : tmp[point1++];
        }
        //如果tmp还没有遍历完，将tmp后面的补到nums后面
        for(int i = point1; i < (((begin + end) >> 1) - begin); i++){
            nums[point3++] = tmp[i];
        }

    }


}
