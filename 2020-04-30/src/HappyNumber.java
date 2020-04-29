import java.util.HashSet;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(2));
    }
}

class Solution {
    public boolean isHappy(int n) {
        //循环运行存到hash表中，hashSet
        HashSet<Integer> table = new HashSet<>();
        while(true){
            n = oneHappy(n);
            if(table.contains(n))
                return false;
                //n最高位等于1，其它位为零
            else if(n == 1)
                return true;
            else
                table.add(n);
        }
    }
    private int oneHappy(Integer n){
        int sum = 0;
        int tmp = 0;
        while(n != 0){
            tmp = n % 10;
            sum += tmp *tmp;
            n = (n - tmp) / 10;
        }
        return sum;
    }
}
