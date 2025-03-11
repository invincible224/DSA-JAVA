// 152. Maximum Product Subarray

/*Given an integer array nums, find a subarray that has the largest product, and return the product.

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
*/
public class MaxProductSubarray {
    // Brute force approach
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) { // Handle empty array
            return 0;
        }

        int max = Integer.MIN_VALUE; // Initialize max to the smallest possible value

        // Outer loop to define the start of the subarray
        for (int i = 0; i < n; i++) {
            int product = 1; // Initialize product for the current subarray

            // Inner loop to define the end of the subarray
            for (int j = i; j < n; j++) {
                // Multiply elements in the current subarray
                product *= nums[j];
                // Update max with the highest product found so far
                max = Math.max(product, max);
            }
        }

        return max;
    }
}

// Optimal solution : TC = O(n) and SC = O(1)
// Intuition:
    // case1 : all positive
    // case2: even negative
    // case3: odd negative
    // case4: zero
    // we will traverse the array from start with prefix and the end with suffix and multiply if the product became 0 we'll reset it to 1
    // [2,3,5,-1,0,4,7,-9,0,1,2,4,8,-9]
    // the array will be get divided  like [2,3,5,-1], [4,7,-9],[1,2,4,8,-9]
    
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length; // Get the length of the array

        // Edge case: If the array is empty, return 0
        if (n == 0) { 
            return 0;
        }

        int max = Integer.MIN_VALUE; // Initialize `max` to the smallest possible value
        int prefix = 1; // Tracks the product of elements from the left (prefix product)
        int suffix = 1; // Tracks the product of elements from the right (suffix product)

        // Iterate through the array from both ends simultaneously
        for (int i = 0; i < n; i++) {
            // If the prefix product becomes zero, reset it to 1
            if (prefix == 0) { 
                prefix = 1; 
            }

            // If the suffix product becomes zero, reset it to 1
            if (suffix == 0) { 
                suffix = 1; 
            }

            // Update the prefix product by multiplying the current element from the start
            prefix = prefix * nums[i];

            // Update the suffix product by multiplying the current element from the end
            suffix = suffix * nums[n - i - 1];

            // Update the maximum product by taking the maximum of:
            // 1. The current maximum product (`max`)
            // 2. The current prefix product (`prefix`)
            // 3. The current suffix product (`suffix`)
            max = Math.max(max, Math.max(prefix, suffix));
        }

        return max; // Return the maximum product found
    }
}
