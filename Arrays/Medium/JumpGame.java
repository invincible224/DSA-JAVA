public class JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            // Track the maximum reachable position
            int maxReach = 0;
            int n = nums.length;
            
            for (int i = 0; i < n; i++) {
                // If we can't reach the current position, return false
                if (i > maxReach) {
                    return false;
                }
                
                // Update the maximum reachable position
                maxReach = Math.max(maxReach, i + nums[i]);
                
                // If we can reach the last index, return true
                if (maxReach >= n - 1) {
                    return true;
                }
            }
            
            return false;
        }
    }
}
