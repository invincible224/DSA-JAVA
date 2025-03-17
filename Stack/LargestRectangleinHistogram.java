import java.util.Stack;

public class LargestRectangleinHistogram {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int maxArea = 0;
            for (int i = 0; i < n; i++) {
                int minHeight = Integer.MAX_VALUE;
                for (int j = i; j < n; j++) {
                    minHeight = Math.min(minHeight, heights[j]);
                    maxArea = Math.max(maxArea, minHeight * (j - i + 1));
                }
            }
            return maxArea;
        }
    }

    // Better -----------------------------------------
    class Solution2 {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int maxArea = 0;

            // Find the Previous Smaller Element (PSE) and Next Smaller Element (NSE)
            // indices
            int[] pse = findPSE(heights);
            int[] nse = findNSE(heights);

            // Calculate the largest rectangle area for each bar
            for (int i = 0; i < n; i++) {
                // Width of the rectangle is calculated as (nse[i] - pse[i] - 1)
                int width = nse[i] - pse[i] - 1;
                int area = heights[i] * width;
                maxArea = Math.max(maxArea, area);
            }
            return maxArea;
        }

        /**
         * Function to find Previous Smaller Element (PSE) indices.
         * PSE[i] gives the index of the nearest smaller element to the left of
         * heights[i].
         */
        int[] findPSE(int[] heights) {
            int n = heights.length;
            Stack<Integer> st = new Stack<>(); // Stack to store indices of elements
            int[] ans = new int[n];

            for (int i = 0; i < n; i++) {
                // Remove elements from stack that are greater than or equal to current element
                while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                    st.pop();
                }

                // If stack is empty, no smaller element exists, so set -1
                ans[i] = st.isEmpty() ? -1 : st.peek();

                // Push current index onto the stack
                st.push(i);
            }
            return ans;
        }

        /**
         * Function to find Next Smaller Element (NSE) indices.
         * NSE[i] gives the index of the nearest smaller element to the right of
         * heights[i].
         */
        int[] findNSE(int[] heights) {
            int n = heights.length;
            Stack<Integer> st = new Stack<>(); // Stack to store indices of elements
            int[] ans = new int[n];

            for (int i = n - 1; i >= 0; i--) { // Start from the right side
                // Remove elements from stack that are greater than the current element
                while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                    st.pop();
                }

                // If stack is empty, no smaller element exists, so set index to n
                ans[i] = st.isEmpty() ? n : st.peek();

                // Push current index onto the stack
                st.push(i);
            }
            return ans;
        }
    }

}
