package Stack;

import javax.swing.text.StyleConstants;

class StackClass {
    class StackNode {
        int data;
        StackNode next;

        StackNode(int a) {
            data = a;
            next = null;
        }
    }

    private StackNode top;

    // Function to push an integer into the stack.
    void push(int a) {
        StackNode newnode = new StackNode(a);
        newnode.next = top;
        top = newnode;
    }

    // Function to remove an item from top of the stack.
    int pop() {
        if (top == null) {
            return -1; // Stack is empty
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }

    // Function to return the top element without removing it.
    int peek() {
        return (top != null) ? top.data : -1;
    }

    void printStack(){
        StackNode temp = top;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

public class StackUsingLL {
    public static void main(String[] args) {
        StackClass s = new StackClass();
        s.push(3);
        s.push(7);
        s.printStack();
        System.out.println(s.peek());
        System.out.println(s.pop());
    }

}
