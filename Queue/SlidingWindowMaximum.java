package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] ans = new int[n - k + 1]; // Result array
        Deque<Integer> deque = new ArrayDeque<>(); // Deque to store indices

        for (int i = 0; i < n; i++) {
            // Remove indices of elements not in the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices of smaller elements from the back 
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current element's index to the deque
            deque.offerLast(i);

            // Add the maximum element (front of deque) to the result
            if (i >= k - 1) {
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int left = 0;
            int right = k;
            int[] ans = new int[n - k + 1];

            for (int i = 0; i <= n - k; i++) { // Adjusted the loop condition
                left = i;
                int max = Integer.MIN_VALUE;

                while (left < right) {
                    max = Math.max(max, nums[left]);
                    left++;
                }
                ans[i] = max;
                right++; // Increment right to slide the window
            }
            return ans;
        }
    }
}
