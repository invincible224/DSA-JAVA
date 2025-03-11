package Arrays.Medium;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store numbers and their indices as key-value pairs.
        HashMap<Integer, Integer> map = new HashMap<>();

        // Loop through the array to check for the complement of each number.
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement required to reach the target.
            int more = target - nums[i];

            // Check if the complement is already in the map.
            // If it is, we have found the two numbers that sum to the target.
            if (map.containsKey(more)) {
                // Return their indices: the index of the complement from the map
                // and the current index.
                return new int[] { map.get(more), i };
            }

            // If the complement is not found, store the current number with its index in
            // the map.
            // This allows us to reference it later as a potential complement for future
            // elements.
            map.put(nums[i], i);
        }

        // If no solution is found, return an empty array (this shouldn't happen as per
        // the problem constraints).
        return new int[0];
    }

// -------------------->>>>>>>>>>>>>>>>>>
// Brute force 
/*public static int[] twoSum(int[] nums, int target) {
        // Iterate through each pair of elements
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // Check if the sum of the pair equals the target
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j}; // Return the indices of the pair
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    } 
*/

}
