// Array is sorted and rotated and contains duplicates

public class findnRotated {
        public boolean search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
    
            while (left <= right) {
                int mid = left + (right - left) / 2;
    
                if (nums[mid] == target) {
                    return true; // Found the target
                }
    
                // Handle duplicates: Skip identical elements
                if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                    left++;
                    right--;
                    continue;
                }
    
                // Check if the left half is sorted
                if (nums[left] <= nums[mid]) {
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1; // Search left half
                    } else {
                        left = mid + 1;  // Search right half
                    }
                } 
                // Otherwise, the right half is sorted
                else {
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1; // Search right half
                    } else {
                        right = mid - 1; // Search left half
                    }
                }
            }
            return false; // Target not found
        }
    }
    

