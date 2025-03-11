import java.util.Scanner;

public class LinkedList {
    private Node head;
    private Node tail;
    static int length;

    // Creating a Node
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    // Constructor (optional since default values are null for node and 0 for an
    // integer)
    public LinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    // Create a Linked List
    public void createList() {
        Scanner sc = new Scanner(System.in);
        int value;
        while (true) {
            System.out.println("Enter values of nodes(00 for exit)");
            value = sc.nextInt();
            Node newNode = new Node(value);

            if (value == 00) {
                break;
            }
            if (head == null) {
                head = newNode;
                tail = newNode;
                length += 1;
            } else {
                tail.next = newNode;
                tail = newNode;
                length += 1;
            }

        }
    }

    // Print the list
    public void printList() {
        Node temp = head;
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("\nHead = " + head.value);
        System.out.println("Tail = " + tail.value);
        System.out.println("Length = " + length);
    }

    // Append the Node to the list
    public void appendLL(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length += 1;
    }

    // Prepend the Node to the list
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length += 1;
    }

    // removing the last node
    public void removeLast() {
        Node temp, pre;
        temp = pre = head;
        if (head == null) {
            System.out.println("List is already empty.");
        } else if (head == tail) {
            System.out.println(head.value + " is removed.");
            head = null;
            tail = null;
            length--;
        } else {
            while (temp.next != null) {
                pre = temp;
                temp = temp.next;
            }
            tail = pre;
            System.out.println(temp.value + " is removed.");
            tail.next = null;
            length -= 1;
        }
    }

    // Remove first Node
    public void removeFirst() {
        if (head == null) {
            System.out.println("List is already empty.");
        } else if (head == tail) {
            System.out.println(head.value + " is removed.");
            head = tail = null;
            length--;
        } else {
            Node temp = head;
            head = head.next;
            temp.next = null;
            System.out.println(temp.value + " is removed.");
            length--;
        }
    }

    // Get the node
    public Node getNode(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Invalid Index");
            return null;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // Set the value to the node
    public void setNode(int index, int value) {
        if (index < 0 || index >= length) {
            System.out.println("Invalid index");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.value = value;
        System.out.println("Value changed Successfully");
    }

    // Insert the node
    public void insert(int index, int value) {
        if (index < 0 || index > length) {
            System.out.println("Invalid index");
        }
        if (index == 0) {
            prepend(value);
        } else if (index == length) {
            appendLL(value);
        } else {
            Node newNode = new Node(value);
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            // Create a link between the next_node and newNode first then with the temp
            // node(prevNode)
            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println("Node inserted successfully.");
            length += 1;
        }
    }

    // Remove from given index
    public void remove(int index) {
        if (index < 0 || index > length) {
            System.out.println("Invalid index");
        }

        if (index == 0) {
            removeFirst();
        } else if (index == length - 1) {
            // index will start from 0 but len will 1
            removeLast();
        } else {
            Node temp, prev;
            temp = prev = head;
            for (int i = 0; i < index; i++) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
            temp.next = null;
            System.out.println(temp.value + "Removed Successfully.");
            length -= 1;
        }
    }

    // Reverse a LInked List
    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    // reverse a list (without tail)
    // public Node reverseList1(Node head) {
    // if(head==null){return null;}
    // Node temp,prev,nextNode;
    // temp=head;
    // prev=null;

    // while(temp!=null){
    // nextNode=temp.next;
    // temp.next=prev;
    // prev=temp;
    // temp=nextNode;
    // }
    // return prev;

    // }

    // reversal using recursion

    public Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseList(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}