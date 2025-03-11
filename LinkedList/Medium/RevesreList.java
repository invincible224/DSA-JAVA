package LinkedList.Medium;

public class RevesreList {
    /**
 * Definition for singly-linked list node
 * Each node in the linked list has:
 * - An integer value (val)
 * - A reference to the next node (next)
 */
public class ListNode {
    int val;                // Stores the value of the current node
    ListNode next;          // Reference to the next node in the list
    
    // Three constructors:
    ListNode() {}           // Default constructor
    ListNode(int val) {     // Constructor with just the value
        this.val = val;
    }
    ListNode(int val, ListNode next) {    // Constructor with value and next node
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        // If the list is empty, return null
        if(head == null) {
            return null;
        }

        ListNode prev = null;    // Previous node pointer (starts as null)
        ListNode curr = head;    // Current node pointer (starts at head)
        ListNode nextNode;       // Next node pointer for temporary storage

        // Iterate through the list until we reach the end
        while(curr != null) {
            // Step 1: Save the next node before we change any pointers
            nextNode = curr.next;

            // Step 2: Reverse the link - make current node point to previous node
            curr.next = prev;

            // Step 3: Move prev and curr pointers one step forward
            prev = curr;
            curr = nextNode;
        }

        // prev is now pointing to the last node (new head of reversed list)
        return prev;
    }
}
}
