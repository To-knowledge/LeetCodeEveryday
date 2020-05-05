import java.util.HashMap;

public class LengthOfLargestSubString {
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //hash表+双指针
        HashMap<Character, Integer> hashMap = new HashMap<>();
        //左开右闭
        int begin = -1;
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            Character tmp = s.charAt(i);
            if(hashMap.containsKey(tmp) && hashMap.get(tmp) > begin){
                begin = hashMap.get(tmp);
                hashMap.replace(tmp, i);
            }else{
                hashMap.put(tmp, i);
                result = result > i-begin ? result : i-begin;
            }

        }

        return result;
    }
}
