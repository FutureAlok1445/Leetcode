import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        int left=0;
        int result=0;

        for (int right=0;right<s.length();right++){
            char current = s.charAt(right);

            int idx = map.getOrDefault(current,-1);

            if(idx>=left){
                left=idx+1;
            }

            map.put(current,right);

            int currentlength=right - left +1;

            if(currentlength>result){
                result = currentlength;
            }
        }
        return result;
    }
}