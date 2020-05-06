public class mincostTickets {
    public static void main(String[] args) {
        int[] arr1 = {1,2,4,5,6,7,9,10,12,15,17,19,20,21,22,24,25,27,29,30,32,34,35,36,37,39,40,41,42,43,44,45,46,47,48,49,50,53,54,55,57,58,59,60,61,62,64,67,68,69,70,71,72,73,74,76,77,78,79,81,84,85,86,87,89,90,92,93,95,96,99,101,102,103,104,105,106,107,108,110,113,114,116,118,119,120,121,122,123,126,128,131,132,133,135,136,137,138,139,140,143,144,145,146,147,150,151,152,153,154,155,156,158,159,160,162,164,169,171,172,173,175,176,177,178,180,181,183,184,186,188,190,191,192,194,195,197,198,199,200,201,202,203,204,210,211,213,216,217,219,220,222,225,227,228,231,232,235,236,240,241,242,244,245,246,248,249,250,251,252,254,255,257,259,261,265,267,271,273,274,276,277,278,279,280,281,283,284,285,286,287,288,289,290,293,295,296,297,299,300,302,303,304,306,307,308,309,310,311,314,319,321,322,323,325,326,330,332,334,335,337,339,340,341,342,343,344,345,346,347,348,350,351,353,354,356,358,360,361};
        int[] arr2 = {38,206,728};
        System.out.println(new Solution().mincostTickets(arr1, arr2));
    }

}

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        return mincostTickets(days, costs, days.length);
    }

    private int mincostTickets(int[] days, int[] costs, int end) {
        if(end == 0)    return 0;
        //动态规划，自顶向下
        int end1 = end;
        int end7 = end;
        int end30 = end;
        //防止数组越界
        while(end1 > 0 && days[end - 1] - days[end1 - 1] < 1) end1--;
        while(end7 > 0 && days[end - 1] - days[end7 - 1] < 7) end7--;
        while(end30 > 0 && days[end - 1] - days[end30 - 1] < 30) end30--;

        if((end - end7) * costs[0] < costs[1] && (end - end30) * costs[0] < costs[2])
            return costs[0] + mincostTickets(days, costs, end1);
        else if((end - end7) * costs[0] >= costs[1] && (end - end30) * costs[0] >= costs[2])
            return Math.min(costs[0] + mincostTickets(days, costs, end1),Math.min(costs[1] + mincostTickets(days, costs, end7), costs[2] + mincostTickets(days, costs, end30)));
        else if((end - end7) * costs[0] >= costs[1])
            return Math.min(costs[0] + mincostTickets(days, costs, end1), costs[1] + mincostTickets(days, costs, end7));
        else
            return Math.min(costs[0] + mincostTickets(days, costs, end1),costs[2] + mincostTickets(days, costs, end30));
    }
}
