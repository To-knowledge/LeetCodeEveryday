package com.xiao.每日一题;

/*
* 接雨水
*
* */

public class EverydayRecommended {


}
/*
* 非动态规划
* */
class Solution {
    public int trap(int[] height) {
        if(height == null) return 0;
        int max = 0;
        int result = 0;
        //寻找最大值的索引
        for(int i = 0; i < height.length; i++){
            max = height[i] > height[max] ? i : max;
        }
        int local_max = 0;
        //从左边逼近最大值
        for(int i = 0; i < max; i++){
            if(local_max >= height[i]){
                result += local_max - height[i];
            }
            else{
                local_max = height[i];
            }
        }
        local_max = 0;
        //从右边逼近最大值
        for(int i = height.length - 1; i > max; i--){
            if(local_max >= height[i]){
                result += local_max - height[i];
            }
            else{
                local_max = height[i];
            }
        }


        return result;
    }
}

/*
 * 动态规划
 * */

class Solution1 {
    public int trap(int[] height) {
        if(height == null) return 0;
        int max = 0;
        int result = 0;
        //寻找最大值的索引
        for(int i = 0; i < height.length; i++){
            max = height[i] > height[max] ? i : max;
        }
        int local_max = 0;
        //从左边逼近最大值
        for(int i = 0; i < max; i++){
            if(local_max >= height[i]){
                result += local_max - height[i];
            }
            else{
                local_max = height[i];
            }
        }
        local_max = 0;
        //从右边逼近最大值
        for(int i = height.length - 1; i > max; i--){
            if(local_max >= height[i]){
                result += local_max - height[i];
            }
            else{
                local_max = height[i];
            }
        }


        return result;
    }
}