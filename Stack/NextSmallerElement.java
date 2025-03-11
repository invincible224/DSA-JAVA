
import java.util.Stack;

public class NextSmallerElement {

    public class Solution {

        public int[] prevSmaller(int[] A) {
            Stack<Integer> st = new Stack<>();  // Using generics for type safety
            int[] ans = new int[A.length];

            for (int i = 0; i < A.length; i++) {
                // Pop elements from stack while they're greater than or equal to current element
                // (not smaller as in your original code)
                while (!st.isEmpty() && st.peek() >= A[i]) {
                    st.pop();
                }

                // If stack is empty, no smaller element exists
                if (st.isEmpty()) {
                    ans[i] = -1;
                } else {
                    // Top of stack is the nearest smaller element
                    ans[i] = st.peek();
                }

                // Push current element onto stack
                st.push(A[i]);
            }

            return ans;
        }
    }
}
