import java.util.Stack;

public class MaximalRectangle {
    class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;
        int[][] preSum = new int[n][m];

        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] == '1') {
                    sum += 1;
                } else {
                    sum = 0;
                }
                preSum[i][j] = sum;
            }
        }

        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, largestHistogram(preSum[i]));
        }

        return maxArea;
    }

    public int largestHistogram(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            while(!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int height = heights[st.pop()];
            int width = st.isEmpty() ? n : n - st.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}

}
