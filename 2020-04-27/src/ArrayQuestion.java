public class ArrayQuestion {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        new Solution().search(arr, 3);
    }
}

class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }
    private int search(int[] nums, int target, int begin, int end){
        //递归结束条件
        if(begin == end)    return -1;
        if(begin == end - 1){
            if(nums[begin] == target)
                return begin;
            else
                return -1;
        }
        //二分寻找中值
        //二分中值有错
        //int mid = (begin >> 1) + (end >> 1);
        int mid = (begin + end) >> 1;
        //判断是在左半边查找，还是在右半边查找
        if(nums[mid] >= nums[begin]){
            if(target >= nums[mid] || target < nums[begin])
                return search(nums, target, mid, end);
            else
                return search(nums, target, begin, mid);
        }
        else{
            if(target < nums[mid] || target >= nums[begin])
                return search(nums, target, begin, mid);
            else
                return search(nums, target, mid, end);
        }
    }
}
