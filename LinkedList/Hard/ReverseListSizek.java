package LinkedList.Hard;

import LinkedList.Medium.OddEvenList.ListNode;

public class ReverseListSizek {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k <= 1) {
                return head; // No need to process
            }
    
            ListNode temp = head;
            ListNode nextNode;
            ListNode prev = null;
    
            while (temp != null) {
                // Find the k-th node from the current position
                ListNode kthNode = findNode(temp, k);
                if (kthNode == null) {
                    if (prev != null) {
                        prev.next = temp; // Link remaining nodes
                    }
                    break;
                }
    
                // Save the next group's starting point
                nextNode = kthNode.next;
                // Temporarily detach the current group
                kthNode.next = null;
    
                // Reverse the current group
                ListNode newHead = reverse(temp);
    
                // Update links
                if (temp == head) {
                    head = kthNode; // Update the head of the entire list
                } else {
                    prev.next = kthNode;
                }
    
                // Update `prev` to point to the end of the reversed group
                prev = temp;
                temp = nextNode;
            }
    
            return head;
        }
    
        // Function to find the k-th node from the current node
        private ListNode findNode(ListNode temp, int k) {
            k -= 1; // To account for 0-based indexing in the loop
            while (temp != null && k > 0) {
                k--;
                temp = temp.next;
            }
            return temp;
        }
    
        // Function to reverse a linked list
        private ListNode reverse(ListNode head) {
            ListNode curr = head;
            ListNode prev = null;
    
            while (curr != null) {
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }
            return prev;
        }
        
}
