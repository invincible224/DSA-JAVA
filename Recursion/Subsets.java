package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {

    // Better solution but not best for bigger arrays
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            // We use a HashSet to automatically handle duplicate subsets
            // (though for unique elements in nums, all subsets will be unique anyway)
            Set<List<Integer>> result = new HashSet<>();
            int n = nums.length; // Number of elements in input array

            // Generate all possible subset combinations using bitmask approach
            // There are 2^n possible subsets for an array of size n
            for (int mask = 0; mask < (1 << n); mask++) {
                // Each mask represents a unique subset:
                // - In binary, each bit indicates whether to include that element
                // - For mask=5 (101), it means include elements at positions 0 and 2

                List<Integer> subset = new ArrayList<>(); // Will store current subset

                // Check each bit position in the current mask
                for (int i = 0; i < n; i++) {
                    // (1 << i) creates a bitmask with only the i-th bit set
                    // (mask & (1 << i)) checks if the i-th bit is set in the current mask
                    if ((mask & (1 << i)) != 0) {
                        // If the bit is set, include the corresponding element
                        subset.add(nums[i]);
                    }
                }

                // Add the generated subset to our result set
                // HashSet automatically handles duplicates if any
                result.add(subset);
            }

            // Convert the HashSet to List<List<Integer>> before returning
            return new ArrayList<>(result);
        }
    }
}
