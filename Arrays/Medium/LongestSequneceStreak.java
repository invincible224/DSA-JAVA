package Arrays.Medium;

import java.util.HashSet;

public class LongestSequneceStreak {
    class Solution {
    public int longestConsecutive(int[] nums) {
        // If the array is empty, return 0 because there are no elements to form a sequence.
        if (nums.length == 0) {
            return 0;
        }

        // Use a HashSet to store the elements of the array for fast lookup.
        HashSet<Integer> set = new HashSet<>();

        // Add all the elements of the array into the HashSet.
        for (int num : nums) {
            set.add(num);
        }

        // Variable to track the length of the longest consecutive sequence.
        int longStreak = 0;

        // Iterate through each number in the HashSet.
        for (int num : set) {
            // Check if 'num' is the start of a sequence.
            // A number is the start of a sequence if 'num-1' is not in the set.
            if (!set.contains(num - 1)) {
                // Initialize the current number and the current streak length.
                int currNum = num;
                int currStreak = 1;

                // Increment the current number and streak length while consecutive numbers exist in the set.
                while (set.contains(currNum + 1)) {
                    currNum++;
                    currStreak++;
                }

                // Update the longest streak length if the current streak is longer.
                longStreak = Math.max(currStreak, longStreak);
            }
        }

        // Return the length of the longest consecutive sequence found.
        return longStreak;
    }
}

}
