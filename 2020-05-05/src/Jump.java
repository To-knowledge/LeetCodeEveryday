public class Jump {
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        new Solution2().jump(arr);
    }

}

class Solution2 {
    public int jump(int[] nums) {
        //贪心策略
        int index = 0;
        int step = 0;
        int optimal = 0;
        while(index < nums.length - 1){
            optimal = 0;
            for(int i = 1; i <= nums[index]; i++){
                //找到可以跳的最远的那一格
                if(index + i == nums.length - 1){
                    optimal = i;
                    break;
                }
                if(i + nums[index + i] > optimal + nums[index + optimal])
                    optimal = i;
            }
            //更新index到该格子
            index += optimal;
            step++;
        }

        return step;
    }
}
