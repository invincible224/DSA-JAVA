import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums); // Sort the array to use two-pointer approach
            int n = nums.length;
            List<List<Integer>> list = new ArrayList<>();
    
            for (int i = 0; i < n; i++) {
                // Skip duplicate elements for the first number
                if (i > 0 && nums[i] == nums[i - 1]) continue;
    
                for (int j = i + 1; j < n; j++) {
                    // Skip duplicate elements for the second number
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
    
                    int k = j + 1;
                    int l = n - 1;
    
                    while (k < l) {
                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
    
                        if (sum < target) {
                            k++;
                        } else if (sum > target) {
                            l--;
                        } else {
                            // Add the quadruplet to the list
                            list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
    
                            k++;
                            l--;
                            // Skip duplicate elements for the third number
                            while (k < l && nums[k] == nums[k + 1]) k++;
    
                            // Skip duplicate elements for the fourth number
                            while (k < l && nums[l] == nums[l - 1]) l--;
    
                            
                        }
                    }
                }
            }
    
            return list;
        }
    }
    

    public class FourSum {
    
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] nums = {1, 0, -1, 0, -2, 2};
            int target = 0;
            System.out.println(solution.fourSum(nums, target));
    }
}

