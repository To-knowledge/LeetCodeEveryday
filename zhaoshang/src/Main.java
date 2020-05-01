import java.util.*;

import static java.lang.Math.sqrt;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int length = (N * (N + 1)) >> 1;
        int[] input = new int[length];
        for(int i = 0; i < length; i++){
            input[i] = s.nextInt();
        }
        System.out.println(abc(input,0));
    }
    private static int abc(int[] input, int index1){
        int indexLeft = index1 + (((int)(sqrt(1 + 8 * index1) + 1))>>1);
        if(indexLeft < input.length)
            return input[index1] + max(abc(input,indexLeft), abc(input, indexLeft+1));
        return input[index1];
    }
    private static int max(int a, int b){
        return a > b ? a : b;
    }
}