// Approach:
// Identify and eliminate the sorted part but before eliminating it just store the mini form that part


public class findMinRotated {
        public int findMin(int[] nums) {
            // If the array is empty, return -1 (error case)
            if(nums.length == 0){
                return -1;
            }
    
            int low = 0;  // Start index of the array
            int high = nums.length-1;  // End index of the array
            int ans = Integer.MAX_VALUE;  // Variable to store the minimum value
    
            // Binary search loop to find the minimum element
            while(low <= high){
                int mid = low + (high - low) / 2;  // Avoiding overflow when calculating mid
                
                // If the left portion is sorted (including the case when low == mid)
                // in case of only two elements [2,1] ("=")
                if(nums[low] <= nums[mid]){
                    // The minimum element could be at index 'low'
                    ans = Math.min(ans, nums[low]);
                    // Move to the right half to find a potentially smaller value
                    low = mid + 1;
                }
                else{
                    // The right portion is unsorted, so the minimum is in the left half
                    ans = Math.min(ans, nums[mid]);
                    // Move to the left half to continue searching
                    high = mid - 1;
                }
            }
            return ans;
        }    
}

