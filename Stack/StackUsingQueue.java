package Stack;

import java.util.Queue;
import java.util.LinkedList;
public class StackUsingQueue {

class MyStack {
    private Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        int s = q.size();
        q.offer(x); // Add element to queue
        for (int i = 0; i < s; i++) {
            q.offer(q.poll()); // Move all previous elements to the back
        }
    }
    
    public int pop() {
        return q.isEmpty() ? -1 : q.poll(); // Remove and return the top element
    }
    
    public int top() {
        return q.isEmpty() ? -1 : q.peek(); // Return the top element without removing
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

}
