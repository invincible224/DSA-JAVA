
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MiniSubarraySum {
    // ---------Brute force-----------
    class Solution {
        public int sumSubarrayMins(int[] arr) {
            int sum = 0;
            int mod = 1000000007;
            int n = arr.length;
            for(int i=0;i<n;i++){
                int mini = arr[i];
                for(int j=i;j<n;j++){
                    mini = Math.min(mini,arr[j]);
                   sum = (sum+mini) % mod;
                }
             }
            
            return sum;
        }
    } 
}

// ----Optimal solution----------------
class Solution2 {
    public int sumSubarrayMins(int[] arr) {
        int length = arr.length;
        // Arrays to keep track of previous smaller and next smaller elements
        int[] left = new int[length];
        int[] right = new int[length];
      
        // Initialize left array with -1 indicating the start of array
        Arrays.fill(left, -1);
        // Initialize right array with length of array indicating the end of array
        Arrays.fill(right, length);
      
        // Stack to keep track of elements while traversing
        Deque<Integer> stack = new ArrayDeque<>();
      
        // Calculate previous smaller elements for each element in the array
        for (int i = 0; i < length; ++i) {
            // Popping all elements which are greater than the current element
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            // The current top of the stack indicates the previous smaller element
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            // Push the current index into the stack
            stack.push(i);
        }
      
        // Clear the stack for next traversal
        stack.clear();
      
        // Calculate next smaller elements for each element in the array in reverse order
        for (int i = length - 1; i >= 0; --i) {
            // Popping all elements which are greater than or equal to the current element
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            // The current top of the stack indicates the next smaller element
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            // Push the current index into the stack
            stack.push(i);
        }
      
        // The mod value for big integer operations to prevent overflow
        int mod = (int) 1e9 + 7;
        // The result variable to keep track of the sum of subarray minimums
        long answer = 0;
      
        // Calculate the contribution of each element as a minimum in its possible subarrays
        for (int i = 0; i < length; ++i) {
            // Total count of subarrays where arr[i] is min is (i - left[i]) * (right[i] - i)
            // Multiply the count by the value itself and apply modulo operation
            answer += (long) (i - left[i]) * (right[i] - i) % mod * arr[i] % mod;
            // Ensure the running sum doesn't overflow
            answer %= mod;
        }
      
        // Cast the long result to int before returning as per method return type
        return (int) answer;
    }
}