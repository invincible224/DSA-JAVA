public class SquareRoot {
    class Solution {
        public int mySqrt(int x) {
            // Initialize variables for binary search range
            int ans = 0; // Stores the final answer
            int low = 1, high = x; // Search space from 1 to x
    
            while (low <= high) { 
                // To avoid potential overflow in (low + high) / 2
                int mid = low + (high - low) / 2;
                
                // Use long to prevent integer overflow when squaring mid
                long square = (long) mid * mid;
    
                if (square <= x) { 
                    // If mid^2 is within the limit, update answer
                    ans = mid; // mid is a potential answer
                    low = mid + 1; // Try searching for a larger valid value
                } else { 
                    // If mid^2 exceeds x, move the search space left
                    high = mid - 1; 
                }
            }
            
            // Return the largest integer such that ans^2 ≤ x
            return ans;
        }
    }
    
}
