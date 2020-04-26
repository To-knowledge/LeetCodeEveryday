package ProblemSolver;

public class InversePair {
    public static void main(String[] args) {
        int[] arr = {1,3,2,3,1};
        System.out.println(new Solution1().reversePairs(arr));
    }

}

class Solution1 {
    public int reversePairs(int[] nums) {
        //利用非二分的插入排序实现
        int cur = 0;
        int cnt = 0;
        for(int begin = 1; begin < nums.length; begin++){
            //定义一个动态指针
            //cur = begin;
            //使用二分查找优化
            // while(cur > 0 && compare(nums,cur,cur-1) < 0){
            //     swap(nums,cur,cur-1);
            //     cnt++;
            //     cur--;
            // }
            //左闭右开
            cnt += binarySearchAndMove(nums,0,begin);
        }
        return cnt;
    }
    private int binarySearchAndMove(int[] nums,int a, int b){
        //重写二分法
        int begin = a;
        int end = b;
        int mid = 0;
        int tmp = nums[b];
        //寻找插入位置
        while(end > begin){
            mid = (end + begin) >> 1;
            if(tmp >= nums[mid]) begin = mid+1;
            else    end = mid;
        }
        //进行插入操作
        insert(nums, b, begin);
        //返回逆序对个数
        return b - begin;
    }

    private void insert(int[] nums, int source, int dest){
        int tmp = nums[source];
        for(; source >= dest + 1; source--){
            nums[source] = nums[source-1];
        }
        nums[dest] = tmp;
    }


    private int compare(int[] nums, int a, int b){
        //可能会出现超限，直接比较大小？
        return nums[a] >= nums[b] ? 1 : -1;
        // return nums[a] - nums[b];
    }
    private void swap(int[] nums, int a, int b){
        /**int越界
         nums[a] = nums[a] + nums[b];
         nums[b] = nums[a] - nums[b];
         nums[a] = nums[a] - nums[b];
         */
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}