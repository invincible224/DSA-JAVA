package DoublyLL;

public class removeDupsNode {
    Node removeDuplicates(Node head) {
        // If the list is empty or has only one node, return the head as no duplicates
        // exist.
        if (head == null || head.next == null) {
            return head;
        }

        Node temp = head; // Start from the head of the linked list.

        // Traverse the linked list while ensuring that the next node is not null.
        while (temp != null && temp.next != null) {
            // Check if the current node and the next node have the same data (duplicate
            // case).
            if (temp.data == temp.next.data) {
                // Point to the node after the duplicate (skipping the duplicate node).
                Node nextnode = temp.next.next;

                // Remove the duplicate node by linking current node to the next valid node.
                temp.next = nextnode;

                // If the next node exists, update its prev pointer to maintain the doubly
                // linked list integrity.
                if (nextnode != null) {
                    nextnode.prev = temp;
                }
            } else {
                // If no duplicate found, move to the next node.
                temp = temp.next;
            }
        }

        // Return the head of the updated linked list with duplicates removed.
        return head;
    }
}
