package Queue;

// Cirular queue

class Queue {

    int start, end;
    int size = 10;
    int currSize;
    int[] arr;

    Queue() {
        start = -1;
        end = -1;
        currSize = 0;
        arr = new int[size];
    }


    public boolean isEmpty() {
        return currSize == 0;
    }


    public boolean isFull() {
        return currSize == size;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot insert " + x);
            return;
        }

        if (isEmpty()) {
            start = 0;
            end = 0;
        } else {
            end = (end + 1) % size;
        }
        
        arr[end] = x;
        currSize++;
        System.out.println(x + " inserted.");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot pop.");
            return -1;
        }

        int ele = arr[start];

        if (start == end) { 
            start = end = -1;
        } else {
            start = (start + 1) % size;
        }

        currSize--;
        System.out.println(ele + " popped.");
        return ele;
    }

    public void front() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Front = " + arr[start]);
        }
    }
}

public class QueueArray {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.push(12);
        q.push(45);
        q.push(5);
        q.push(459);
        q.front();
        q.pop();
        q.front();
    }
}
