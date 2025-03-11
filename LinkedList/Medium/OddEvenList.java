package LinkedList.Medium;

public class OddEvenList {

    // Optimal Solution
    public class ListNode {
        int val; // Value stored in the node
        public ListNode next; // Reference to the next node in the list

        // Default constructor
        ListNode() {
        }

        // Constructor to initialize the node with a value
        ListNode(int val) {
            this.val = val;
        }

        // Constructor to initialize the node with a value and a reference to the next
        // node
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            // Base case: if the list is empty or contains only one node, return it as is
            if (head == null || head.next == null) {
                return head;
            }

            // Initialize pointers for odd and even nodes
            ListNode odd = head; // Points to the first node (odd index)
            ListNode even = head.next; // Points to the second node (even index)
            ListNode evenStart = even; // Keeps track of the start of the even list

            // Iterate through the list to separate odd and even nodes
            while (even != null && even.next != null) {
                // Link the current odd node to the next odd node
                odd.next = even.next;
                odd = odd.next; // Move the odd pointer to the next odd node

                // Link the current even node to the next even node
                even.next = odd.next;
                even = even.next; // Move the even pointer to the next even node
            }

            // After separating odd and even nodes, link the last odd node to the start of
            // the even list
            odd.next = evenStart;

            // Return the modified list
            return head;
        }
    }

}


// ------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>
// Brute force
/*class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // If the list has 0 or 1 nodes, return as is
        }

        // Create dummy heads for odd and even lists
        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);

        ListNode oddTail = oddDummy; // Tail pointer for the odd list
        ListNode evenTail = evenDummy; // Tail pointer for the even list

        ListNode current = head; // Pointer for traversing the original list
        int index = 1; // Track the index of each node (1-based)

        while (current != null) {
            if (index % 2 != 0) {
                // Odd index: Add to the odd list
                oddTail.next = current;
                oddTail = oddTail.next;
            } else {
                // Even index: Add to the even list
                evenTail.next = current;
                evenTail = evenTail.next;
            }
            current = current.next; // Move to the next node
            index++;
        }

        // Terminate the even list
        evenTail.next = null;

        // Link the odd list to the even list
        oddTail.next = evenDummy.next;

        // Return the head of the odd list
        return oddDummy.next;
    }
}
 */