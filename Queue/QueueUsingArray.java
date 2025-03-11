package Queue;

class MyQueue {

    int front, rear;
	int arr[] = new int[100005];

    MyQueue()
	{
		front=0;
		rear=0;
	}
	
	//Function to push an element x in a queue.
	void push(int x)
	{
	    if(front == 0 && rear == 0){
	        front = rear =1;
	        arr[rear] = x;
	    }
	    else{
	        rear++;
	        arr[rear] = x;
	    }
	} 

    //Function to pop an element from queue and return that element.
	int pop()
	{
		// Your code here
		 if(front == 0 && rear == 0){
	        return -1;
	    }
	    int ele = arr[front];
	    if(front == rear){
	        front = rear = 0;
	        return ele;
	    }
	    else{
	        front++;
	        return ele;
	    }
		
	} 
}

public class QueueUsingArray{
    public static void main(String[] args) {
        MyQueue qu = new MyQueue();
        qu.push(89);
        qu.push(8);
        qu.push(9);
    }
}
