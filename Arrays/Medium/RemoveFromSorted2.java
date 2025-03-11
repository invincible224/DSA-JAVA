package Arrays.Medium;

public class RemoveFromSorted2 {
    public static int removeDuplicates(int[] nums) {
        // Edge case: If the array has 2 or fewer elements, return its length as it already satisfies the condition
        if (nums.length <= 2) return nums.length;

        int k = 2; // Start from the third position

        // Iterate through the array from the third element
        for (int i = 2; i < nums.length; i++) {
            // Compare the current element with the element at position (k - 2)
            // If nums[i] != nums[k - 2], it means the element can be included in the new array
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++; // Move to the next position
            }
        }

        return k; // Return the length of the modified array
    }
}
