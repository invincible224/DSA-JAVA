import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // Brute force Approach
        // Use Set to automatically handle duplicates
        /*
         * Set<List<Integer>> resultSet = new HashSet<>();
         * 
         * // Need three nested loops for brute force
         * for (int i = 0; i < nums.length - 2; i++) {
         * for (int j = i + 1; j < nums.length - 1; j++) {
         * for (int k = j + 1; k < nums.length; k++) {
         * 
         * if (nums[i] + nums[j] + nums[k] == 0) {
         * List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
         * Collections.sort(triplet);
         * resultSet.add(triplet);
         * }
         * }
         * }
         * }
         * 
         * return new ArrayList<>(resultSet);
         */

// --------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>
  
  
  
         // Better approach
        // Use Set to handle duplicates
       /*  Set<List<Integer>> resultSet = new HashSet<>();

        // For each fixed number
        for (int i = 0; i < nums.length - 1; i++) {
            // Use HashMap to store numbers we've seen
            // Use inside the first loop since we need a new map after every inner loop
            // execution else we need to manually empty the loop
            HashSet<Integer> map = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                // Calculate what third number we need
                int target = -(nums[i] + nums[j]);

                // If we've seen this number before
                if (map.contains(target)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], target);
                    Collections.sort(triplet);
                    resultSet.add(triplet);
                }

                // Store current number with its index
                map.add(nums[j]);
            }
        }

        return new ArrayList<>(resultSet); */
// ------------------------------------------>>>>>>>>>>>

        // Optimal solution
        // Sort the array to make it easier to use the two-pointer approach
        Arrays.sort(nums);

        int n = nums.length;
        // List to store the triplets
        List<List<Integer>> list = new ArrayList<>();

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Skip duplicates for the first element
            // if i==0 means it's the first element so we need to check for the other not the first (we also can't check if it's 0 since 0-1 = -1 array out of index error)
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Define two pointers
            int j = i + 1; // Left pointer
            int k = n - 1; // Right pointer

            // Process until the two pointers meet
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k]; // Calculate the sum of the triplet

                if (sum < 0) {
                    j++; // If sum is less than zero, move the left pointer to the right(we need to increase the value)
                } else if (sum > 0) {
                    k--; // If sum is greater than zero, move the right pointer to the left(we need to decrease the value)
                } else {
                    // If sum equals zero, add the triplet to the list
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Move both pointers and skip duplicates
                    j++;
                    k--;

                    // Skip duplicates for the second element
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    // Skip duplicates for the third element
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return list; // Return the list of triplets
    }
}
