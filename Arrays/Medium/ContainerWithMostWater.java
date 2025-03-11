package Arrays.Medium;

// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.

public class ContainerWithMostWater {
    public int maxArea(int[] nums) {
        int left = 0; // Start of the array
        int right = nums.length - 1; // End of the array
        int maxArea = 0; // Variable to store the maximum area

        while (left < right) {
            // Calculate the current area
            int height = Math.min(nums[left], nums[right]); // Smaller height
            int width = right - left; // Distance between lines
            int area = height * width; // Area of the container

            // Update the maximum area
            maxArea = Math.max(maxArea, area);

            // Move the pointer with the smaller height inward
            if (nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea; // Return the maximum area found
    }
}
