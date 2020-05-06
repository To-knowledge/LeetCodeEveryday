public class MinCostTicketsOptimize {
    public static void main(String[] args) {
        int[] arr1 = {1,4,6,7,8,20};
        int[] arr2 = {2,7,15};
        new Solution1().mincostTickets(arr1, arr2);
    }
}

class Solution1 {
    public int mincostTickets(int[] days, int[] costs) {
        int end1 = 0;
        int end7 = 0;
        int end30 = 0;
        //定义一个记忆数组
        int[] minCostTickets = new int[days.length + 1];
        for(int i = 0; i < days.length; i++){
            end1 = i + 1;
            end7 = i + 1;
            end30 = i + 1;
            //防止数组越界
            while(end1 > 0 && days[i] - days[end1 - 1] < 1) end1--;
            while(end7 > 0 && days[i] - days[end7 - 1] < 7) end7--;
            while(end30 > 0 && days[i] - days[end30 - 1] < 30) end30--;
            minCostTickets[i+1] = Math.min(
                    Math.min(costs[0] + minCostTickets[end1],
                             costs[1] + minCostTickets[end7]),
                    costs[2] + minCostTickets[end30]);
        }
        return minCostTickets[days.length];
    }
}
