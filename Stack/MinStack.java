import java.util.Stack;
public class MinStack {

    // Primary stack to store all elements
    private Stack<Integer> st;
    
    // Auxiliary stack to keep track of the minimum values
    private Stack<Integer> minStack;

    // Constructor: Initializes both stacks
    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
    }
    
    // Push operation: Adds an element to the stack
    public void push(int val) {
        st.push(val); // Push the element onto the primary stack
        
        // Push onto minStack if it's empty or val is <= current minimum
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    // Pop operation: Removes the top element from the stack
    public void pop() {
        if (!st.isEmpty()) { // Ensure stack is not empty before popping
            int ele = st.pop(); // Remove the top element from the primary stack
            
            // If the popped element is the current minimum, remove it from minStack as well
            if (ele == minStack.peek()) {
                minStack.pop();
            }
        }
    }
    
    // Top operation: Returns the top element of the stack without removing it
    public int top() {
        return st.peek(); // Get the top element from the primary stack
    }
    
    // getMin operation: Returns the minimum element in the stack
    public int getMin() {
        // Check if minStack is empty (to avoid EmptyStackException)
        if (minStack.isEmpty()) {
            return -1; // Return -1 or throw an exception if the stack is empty
        } else {
            return minStack.peek(); // The top of minStack is always the minimum element
        }
    }
}

