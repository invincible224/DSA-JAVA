// public class LinkedList{
//     private Node head;
//     private Node tail;
//     static int length;

//     // Creating a Node 
//     class Node{
//         int value;
//         Node next;

//         Node(int value){
//             this.value = value;
//         }
//     }

//     LinkedList(int value){
//         Node newNode = new Node(value);
//         head = newNode;
//         tail = newNode;
//         length+=1;
//     }
//     // Print the list
//     public void printList(){
//         Node temp = head;
//         while(temp!=null){
//             System.out.print(temp.value + "->");
//             temp = temp.next;
//         }
//         System.out.println("\nHead = "+head.value);
//         System.out.println("Tail = "+tail.value);
//         System.out.println("Length = "+length);
//     }

//     // Append the Node to the list
//     public void appendLL(int value){
//         Node newNode = new Node(value);
//         if(head == null){
//             head = newNode;
//             tail = newNode;
//         }
//         else{
//             tail.next = newNode;
//             tail = newNode;
//         }
//         length+=1;
//     }

//     // Prepend the Node to the list 
//     public void prepend(int value){
//         Node newNode = new Node(value);
//         if(head==null){
//             head = newNode;
//             tail = newNode;
//         }
//         else{
//             newNode.next = head;
//             head = newNode;
//         }
//         length+=1;
//     }

// }