public class ReversePairs {
    public static void main(String[] args) {
        int[] arr = {9,7,8,6,5,3,1,2};
        new Solution().reversePairs(arr);
    }
}

class Solution {
    int cnt = 0;
    public int reversePairs(int[] nums) {
        //使用归并排序实现
        sort(nums);
        return cnt;
    }

    private void sort(int[] nums){
        divideSortAndMerge(nums, 0, nums.length);
    }
    private void divideSortAndMerge(int[] nums, int begin, int end){
        //至少需要两个元素
        if(end - begin < 2) return;
        // if(begin == end || end == begin + 1)    return;
        //分治
        divideSortAndMerge(nums, begin, (begin+end)>>1);
        divideSortAndMerge(nums, (begin+end)>>1, end);
        //排序完进行合并
        merge(nums, begin, end);
    }
    private void merge(int[] nums, int begin, int end){
        //记录左半数组
        int[] tmp = new int[(end - begin) >>1];
        for(int i = begin; i < (begin+end)>>1; i++){
            tmp[i - begin] = nums[i];
        }
        //开始合并
        int p1 = 0;
        int p2 = (begin+end)>>1;
        while(p1 < tmp.length && p2 < end){
            if(nums[p2] < tmp[p1]){
                cnt+= p2-begin;
                nums[begin++] = nums[p2++];
            }
            else
                nums[begin++] = tmp[p1++];
        }
        while(p1 < tmp.length)
            nums[begin++] = tmp[p1++];
    }
}
