package Queue;
import java.util.Stack; // Importing the Stack class


class MyQueue {
    private Stack<Integer> s1, s2; // Two stacks to simulate queue behavior

    public MyQueue() {
        s1 = new Stack<>(); // Stack to hold queue elements in FIFO order
        s2 = new Stack<>(); // Temporary stack used for reordering
    }
    
    // Push an element into the queue
    public void push(int x) {
        // Move all elements from s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        
        // Insert new element into the empty s1
        s1.push(x);
        
        // Move all elements back from s2 to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
    
    // Removes and returns the front element of the queue
    public int pop() {
        return s1.pop(); // Top of s1 is the front of the queue
    }
    
    // Returns the front element without removing it
    public int peek() {
        return s1.peek();
    }
    
    // Checks if the queue is empty
    public boolean empty() {
        return s1.isEmpty();
    }
}

public class QueueUsingStack {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}

// make stacks s1 and s2
/*Logic / Intuition
A queue processes elements in FIFO order (First In, First Out), while a stack processes elements in LIFO order (Last In, First Out). Since a stack does not naturally support queue operations, we need two stacks (s1 and s2) to reverse the order of elements while inserting them.

Push operation (push(x)):

Move all elements from s1 to s2 (temporarily store them).
Push the new element into s1.
Move all elements back from s2 to s1.
This ensures that the front of the queue is always at the top of s1.
Pop operation (pop()):

Directly remove and return the top of s1 (which represents the front of the queue).
Peek operation (peek()):

Return the top element of s1 (front of the queue) without removing it.
Empty operation (empty()):

Check if s1 is empty.
 */
