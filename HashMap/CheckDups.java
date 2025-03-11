package HashMap;

import java.util.HashMap;

public class CheckDups {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> numIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numIndexMap.containsKey(nums[i])) {
                int prevIndex = numIndexMap.get(nums[i]);
                if (Math.abs(i - prevIndex) <= k) {
                    return true; // Found a valid pair
                }
            }
            numIndexMap.put(nums[i], i); // Update the latest index
        }
        return false; // No valid pair found
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 5, 6};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k)); // Output: true
    }
}
