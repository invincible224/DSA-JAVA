package DoublyLL;

import java.util.Scanner;

// Node class
class Node {
    int value;
    Node next;
    Node prev;
    public int data;

    Node(int value) {
        this.value = value;
        next = null;
        prev = null;
    }
}


// Linked List class
class LL {
    Node head = null;
    Node tail = null;
    int length = 0;

    // create list
    public void createList() {
        Scanner sc = new Scanner(System.in);
        int val;

        while (true) {
            System.out.println("Enter value");
            val = sc.nextInt();
            Node newNode = new Node(val);

            if (val == 000) {
                break;
            } else if (head == null) {
                head = newNode;
                tail = newNode;
                length += 1;

            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                length += 1;
            }

        }
    }

    // Print list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " <=> ");
            temp = temp.next;
        }
    }

    public void append(int value){
        Node newnode = new Node(value);
        if(head == null){
            head = tail = newnode;
        }
        else{
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
    }

    // remove last
    public void removeLastNode(){
        if(head == null){
            return;
        }
        Node temp = tail;
        if(head == tail){
            head = tail = null;
            length--;
        }
        else{
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
            length--;
        }
        printList();
        // return temp;
        
    }

    public void prepend(int value){
        Node newnode = new Node(value);
        if(head == null){
            head = tail = newnode;
        }
        else{
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        }
        length++;
    }

    public void removeFirst(){
        if(head == null){
            System.out.println("Empty List !");
            return;
        }
        if(head == tail){
            head = tail = null;
            length--;
        }
        else{
            Node temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
            length--;
        }
    }

    public Node getNode(int index){
        if(index < 0 || index >= length){
            return null;
        }
        Node temp = head;
        if(index < length/2){
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
        }
        else{
            temp = tail;
            for(int i=length-1;i>index;i--){
                temp = temp.prev;
            }
        }
        return temp;
    }

    public void insert(int index, int value){
        if(index > length || index < 0){
            System.out.println("Index Error !");
            return;
        }
        
        if(index == 0){
            prepend(value);
            return;
        }
        
        if(index == length){
            append(value);
            return;
        }
        
        Node newnode = new Node(value);
        Node prevNode = getNode(index-1);
        Node nextNode = prevNode.next;

        prevNode.next = newnode;
        newnode.prev = prevNode;
        newnode.next = nextNode;
        nextNode.prev = newnode;


    }
    public Node deleteNode(Node head, int x) {
        // Handle edge cases
        if (head == null || x <= 0) {
            return null;
        }
        
        // Calculate length of list
        Node temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        
        // Check if position is valid
        if (x > length) {
            return null;
        }
        
        // Find the node to delete
        temp = head;
        for (int i = 1; i < x; i++) {  // Move to position x
            temp = temp.next;
        }
        
        // Handle deletion based on node position
        Node prevNode = temp.prev;
        Node nextNode = temp.next;
        
        if (prevNode == null) {  // Deleting head
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } 
        else if (nextNode == null) {  // Deleting tail
            prevNode.next = null;
        } 
        else {  // Deleting middle node
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        
        // Clean up references of deleted node
        temp.next = null;
        temp.prev = null;
        
        return head;
    }
}


// Main method 

public class DoublyLL {

    public static void main(String[] args) {
        LL l = new LL();
        l.createList();
        // l.removeLastNode();
        // l.prepend(55);
        // l.removeFirst();
        l.printList();
        l.insert(2, 555);   
        l.printList();
        // System.out.println(l.getNode(5).value);
    }

}
