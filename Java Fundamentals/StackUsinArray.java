package Stack;

class MyStack {
    private int[] arr;
    private int top;
    private static final int MAX_SIZE = 1000;

    public MyStack() {
        arr = new int[MAX_SIZE];
        top = -1;
    }

    public void push(int x) {
        if (top == MAX_SIZE - 1) { // Stack overflow check
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x; // First increment, then assign
    }

    public int pop() {
        if (top == -1) { // Stack underflow check
            return -1;
        }
        return arr[top--]; // Return the top element and decrease top
    }

    public int peek() { // Helper method to check the top element
        if (top == -1) {
            return -1;
        }
        return arr[top];
    }

    public boolean isEmpty() { // Helper method to check if the stack is empty
        return top == -1;
    }
}

public class StackUsinArray {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop()); // 30
        System.out.println(stack.pop()); // 20
        System.out.println(stack.peek()); // 10
        System.out.println(stack.isEmpty()); // false

        stack.pop(); // Removes 10
        System.out.println(stack.isEmpty()); // true
    }
}
