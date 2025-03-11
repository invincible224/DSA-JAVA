package Queue;

class QueueLL {
    class Node {
        int data;
        Node next;

        Node(int a) {
            data = a;
            next = null;
        }
    }

    private Node start;
    private Node end;

    public void push(int x) {
        Node newnode = new Node(x);
        if (start == null) { // If queue is empty
            start = end = newnode;
        } else {
            end.next = newnode;
            end = newnode;
        }
    }

    public int pop() {
        if (start == null) { 
            return -1;
        }
        int temp = start.data;
        if (start == end) { 
            start = end = null;
        } 
        else {
            Node tempNode = start; 
            start = start.next;
            tempNode.next = null; // Help garbage collector
        }
        return temp;
    }

    public int peek() {
        return (start == null) ? -1 : start.data;
    }
}

public class QueueUsingLL {
    public static void main(String[] args) {
        QueueLL q = new QueueLL();
        q.push(12);
        q.push(19);
        q.push(16);

        System.out.println(q.peek()); // Output: 12
        System.out.println(q.pop());  // Output: 12
        System.out.println(q.peek()); // Output: 19
    }
}
