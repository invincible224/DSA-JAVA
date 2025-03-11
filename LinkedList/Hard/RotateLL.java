package LinkedList.Hard;

import LinkedList.Medium.OddEvenList.ListNode;


// ------Optimal TC= O(n)   SC= O(1)
public class RotateLL {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
    
        // Step 1: Find the length of the list
        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
    
        // Step 2: Make the list circular
        temp.next = head;
    
        // Step 3: Find the new head and tail
        k = k % length; // Handle cases where k >= length
        int stepsToNewHead = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }
    
        ListNode newHead = newTail.next;
        newTail.next = null; // Break the circular connection
    
        return newHead;
    }
    
}


// ---------Brute force approach TC= O(n) somewhere about  SC =  O(1)
/*public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k == 0) {
        return head;
    }

    int length = 0;
    ListNode temp = head;
    while (temp != null) { // Find the length of the list
        temp = temp.next;
        length++;
    }

    k = k % length; // Handle cases where k >= length

    for (int i = 0; i < k; i++) {
        ListNode prev = null;
        ListNode curr = head;

        // Traverse to the last node
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        // Move the last node to the front
        curr.next = head;
        head = curr;
        prev.next = null;
    }

    return head;
}
 */