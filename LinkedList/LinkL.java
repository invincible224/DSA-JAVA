package LinkedList;

import java.util.Scanner;


public class LinkL {
    public Node head;
    public Node tail;
    public int length;

    public class Node {
     int value;
     Node next;

     Node(int value){
        this.value = value;
     }
        
    }

    public void createList(){
        Scanner sc = new Scanner(System.in);
        int val;

        while(true){
           System.out.println("Enter value");
           val = sc.nextInt();
           Node newNode = new Node(val);


           if(val == 000){
            break;
           }
           else if(head == null){
            head = newNode;
            tail = newNode;
            length +=1;

           }
           else{
            tail.next = newNode;
            tail = newNode;
            length+=1;
           }

        }
    }

    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.value + "->");
            temp = temp.next;
        }
    }

}

class LL1{
    public static void main(String[] args) {
        LinkL l1 = new LinkL();
        l1.createList();
        l1.print();
    }
}
