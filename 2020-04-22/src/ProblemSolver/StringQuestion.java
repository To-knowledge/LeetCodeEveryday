package ProblemSolver;

public class StringQuestion {
    public static void main(String[] args) {

    }
}

class Solution {
    public String longestPalindrome(String s) {
        if(s == null)   return null;
        int max = 0;
        int snap = 0;
        int tmp = 0;

        //遍历中心
        for(int i = 0; i < (s.length() << 1) - 1; i++){
            //确定中心后，遍历其左右
            tmp = expand(s, i);
            if(tmp > max){
                max = tmp;
                snap = i;
            }
        }
        //输出结果
        int begin = 0;
        int end = 0;

        if (snap % 2 == 0){
            begin = (snap >> 1) - (max >> 1);
        }
        else{
            begin = (snap >> 1) - (max >> 1) + 1;
        }
        end = (snap >> 1) + (max >> 1);
        return s.substring(begin,end);
    }

    private int expand(String s, int i) {
        int begin = 0;
        int end = 0;
        int cnt = 0;
        if(i % 2 == 0){
            begin = (i >> 1) - 1;
            end = (i >> 1) + 1;
            cnt = 1;
        }else{
            begin = (i >> 1);
            end = begin + 1;
            cnt = 0;
        }
        while(begin >= 0 && end <= s.length())
            if(s.charAt(begin) == s.charAt(end)){
                cnt++;
                begin--;
                end++;
            }
            else
                break;
        return cnt;
    }
}
