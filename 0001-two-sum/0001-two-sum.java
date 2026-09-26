import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // for (int i = 0 ; i < nums.length ;i++){
        //     for (int j = i+1; j < nums.length ; j++){
        //         if (nums[i]+nums[j]==target)
        //         {
        //             return new int[]{i,j};
        //         }
        //     }
        // }

        // return new int[]{};

        HashMap<Integer,Integer>map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int needed = target-current;
            if (map.containsKey(needed)){
                return new int[]{map.get(needed),i};
            }
            map.put(current,i);

        }
        return new int[]{};

    }
}