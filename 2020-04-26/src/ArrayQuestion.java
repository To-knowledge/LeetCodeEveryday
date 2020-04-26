import java.util.ArrayList;
import java.util.List;

public class ArrayQuestion {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> res = new Solution().permute(arr);
        for(List<Integer> each : res){
            for(Integer eachin : each)
                System.out.println("-"+eachin+"-");
        }
    }

}

class Solution {
    //定义结果集
    List<List<Integer>> res = new ArrayList<>();
    //定义子结果集
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        //采用回溯实现，选择列表，结束条件，对选择列表进行回溯
        boolean[] flagNums = new boolean[nums.length];
        for(int i = 0; i < flagNums.length; i++)
            flagNums[i] = true;
        /*for(boolean each : flagNums)
            each = true;*/
        backTrace(nums, flagNums);
        return res;
    }

    //回溯函数
    private void backTrace(int[] nums, boolean[] flagNums){
        //回溯结束条件,flag里面的元素全为false
        int i = 0;
        for(; i < flagNums.length; i++){
            if(flagNums[i]) break;
        }
        if(i == flagNums.length){
            res.add(new ArrayList(tmp));
            return;
        }
        //回溯过程
        for(i = 0; i < flagNums.length; i++){
            if(flagNums[i]){
                tmp.add(nums[i]);
                flagNums[i] = false;
            }else
                continue;
            //下一级回溯
            backTrace(nums, flagNums);
            //撤销if里面的操作
            tmp.remove(tmp.size() - 1);
            flagNums[i] = true;
        }
    }
}