package DoublyLL;

class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}
// public class removeNode {
//     public Node removeTheVal(Node head, int x){
//     if (head == null) {
//         return null; // Return null if the list is empty 
//     }
    
//     Node dummy = new Node(0); // Create a dummy node with a placeholder value
//     dummy.next = head;        // Point dummy's next to head
//     head.prev = dummy;        // Update head's previous pointer to dummy
//     Node temp = dummy;        // Start traversing from the dummy node
    
//     while (temp.next != null) {
//         if (temp.next.data == x) { // If the next node contains the value x
//             temp.next = temp.next.next; // Skip the node containing x
//             if (temp.next != null) {    // Update the prev pointer of the next node (if it exists)
//                 temp.next.prev = temp;
//             }
//         } else {
//             temp = temp.next; // Continue traversing when the current node doesn't match x
//         }
//     }
    
//     // Return the modified list, starting from the node after dummy
//     return dummy.next;
// }
    
// }




// -------------Striver-------------------
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // If the linked list is empty, return null immediately
        if (head == null) {
            return null; 
        }

        Node temp = head;  // Start traversing from the head node

        while (temp != null) {  // Traverse through the list until the end
            if (temp.data == x) {  // If the current node's data matches 'x'
                
                // If the node to be deleted is the head of the list
                if (temp == head) {
                    head = head.next;  // Move head to the next node
                }

                // Store references to the next and previous nodes
                Node nextnode = temp.next;
                Node prevnode = temp.prev;

                // If the next node exists, update its previous pointer to skip the current node
                if (nextnode != null) {
                    nextnode.prev = prevnode;
                }

                // If the previous node exists, update its next pointer to skip the current node
                if (prevnode != null) {
                    prevnode.next = nextnode;
                }

                // Move to the next node in the list after deletion
                if (nextnode != null) {
                    temp = nextnode;  // Continue traversal forward
                } else {
                    temp = prevnode;  // If no next node, move backward in the list
                }

            } else {
                // Move to the next node if the current node doesn't contain 'x'
                temp = temp.next;
            }
        }

        // Return the updated head of the linked list
        return head;
    }
}
