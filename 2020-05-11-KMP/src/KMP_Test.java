public class KMP_Test {
    public static void main(String[] args) {
        String pattern = new String("bc");
        String text = new String("abcd");
        int result = new KMP().indexOf(pattern, text);
        System.out.println(result);
    }
}

class KMP {
    public int indexOf(String pattern, String text){
        if(pattern == null || text == null) return -1;
        int pPointer = 0;
        int tPointer = 0;
        //记录模式串与文本串的长度，用于限定pPointer、tPointer的活动范围
        int pLength = pattern.length();
        int tLength = text.length();
        if(pLength == 0 || tLength < pLength) return -1;
        //生成pattern的next数组
        int[] next = next(pattern);
        //开始进行匹配
        while(tPointer < tLength - pLength + 1){
            //pPointer = -1是一个哨兵，该设计有两点：1、生成next时兼容设计；2、-1只能进行if里面的操作
            if(pPointer == -1 || pattern.charAt(pPointer) == text.charAt(tPointer)){
                pPointer++;
                tPointer++;
                //全部匹配成功时
                if(pPointer == pLength) return tPointer - pLength;
            }else{
                //匹配失败时，模式串向右移动pPointer - next[pPointer]
                pPointer = next[pPointer];
            }
        }
        //匹配不成功返回-1
        return -1;
    }

    private int[] next(String pattern){
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int n = -1;
        int i = 0;
        while(i < next.length - 1){
            if(n == -1 || pattern.charAt(i) == pattern.charAt(n)){
                next[i + 1] = n + 1;
                i++;
                n++;
            }else{
                n = next[n];
            }
        }
        return next;
    }
}
