public class SingleNumbers {
    public static void main(String[] args) {
        int[] arr = new int[]{4,1,4,6};
        System.out.println(Integer.toBinaryString(1));
        new Solution().singleNumbers(arr);
    }
}

class Solution {
    public int[] singleNumbers(int[] nums) {
        //将n个数按某一函数映射到数组索引上，模数组长度？此法行不通
        //下面参照官方求解思路
        //1、将数组所有数异或
        int xor = 0;
        for(int i = 0; i < nums.length; i++)
            xor ^= nums[i];
        //2、寻找xor二进制表示中任意一个不为零的位置，一定要从低位向高位找
        // String tmp = Integer.toBinaryString(xor);
        //使用移位运算符
        int i = 0;
        while((xor & 1)  == 0) {
            i++;
            xor = (xor >> 1);
        }
        //3、根据第i位将元素分为两组，分开进行异或
        int xor1 = 0;
        int xor2 = 0;
        for(int j = 0; j < nums.length; j++){
            if(((nums[j] >> i) & 1) == 0)
                xor1 ^= nums[j];
            else
                xor2 ^= nums[j];
        }
        return new int[]{xor1,xor2};
    }
}
