package LinkedList.Medium;

import LinkedList.Medium.OddEvenList.ListNode;

/*19. Remove Nth Node From End of List
Given the head of a linked list, remove the nth node from the end of the list and return its head. */


public class RemoveNnode {
    // Better approach
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // If the list is empty or contains only one node, return null as removing
            // the nth node will result in an empty list.
            if (head == null || head.next == null) {
                return null;
            }
    
            // Step 1: Calculate the length of the linked list
            int length = 0;  // Variable to store the length of the list.
            ListNode temp = head;  // Temporary pointer to traverse the list.
    
            while (temp != null) {
                length++;         // Increment the length for each node.
                temp = temp.next; // Move to the next node.
            }
    
            // Step 2: Calculate the position of the node to remove from the start.
            int k = length - n; // Position from the start is `length - n`.
    
            // Special case: If the node to remove is the head (k == 0),
            // simply return the next node as the new head.
            if (k == 0) {
                return head.next;
            }
    
            // Step 3: Traverse the list to reach the node just before the target node.
            temp = head;          // Reset temp to the head for another traversal.
            ListNode prev = temp; // `prev` will keep track of the node before `temp`.
    
            for (int i = 0; i < k; i++) {
                prev = temp;      // Update `prev` to the current node.
                temp = temp.next; // Move `temp` to the next node.
            }
    
            // Step 4: Remove the target node by updating the `next` pointer of `prev`.
            prev.next = temp.next;
    
            // Step 5: Return the updated head of the linked list.
            return head;
        }
    }
    

    // Optimal approach:
    class Solution2 {
      /*   public ListNode removeNthFromEnd(ListNode head, int n) {
            // Create a dummy node to handle edge cases (e.g., removing the head node).
            ListNode dummy = new ListNode(0);
            dummy.next = head;
    
            // Initialize two pointers.
            ListNode fast = dummy;
            ListNode slow = dummy;
    
            // Move the `fast` pointer `n + 1` steps ahead to maintain a gap of `n` between `fast` and `slow`.
            for (int i = 0; i <= n; i++) {
                fast = fast.next;
            }
    
            // Move both pointers one step at a time until `fast` reaches the end.
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
    
            // `slow.next` is now the node to be removed. Skip it.
            slow.next = slow.next.next;
    
            // Return the head of the updated list.
            return dummy.next;
    }
            */
        }
    }
    

