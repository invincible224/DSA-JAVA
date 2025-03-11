package LinkedList.Medium;

import LinkedList.Medium.OddEvenList.ListNode;

public class SortList {
    // ----------Brute force approach
        // public ListNode sortList(ListNode head) {
        //     if(head == null || head.next== null){
        //         return head;
        //     }
        //     List<Integer> list = new ArrayList<>();
        //     ListNode temp = head;
    
        //     while(temp != null){
        //         list.add(temp.val);
        //         temp = temp.next;
    
        //     }
        //     Collections.sort(list);
    
        //     int i=0;
        //     temp = head;
        //     while(temp != null){
        //         temp.val = list.get(i);
        //         i++;
        //         temp = temp.next;
        //     }
    
        //     return head;
    
        // }
    }

// ------------Optimal  TC =O(n*log n)    SC= O(log n) due to recursive stack space 
class Solution {
    public ListNode sortList(ListNode head) {
        // Base case: If the list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle of the list
        ListNode middle = findMid(head);
        ListNode rightHead = middle.next;
        middle.next = null; // Split the list into two halves

        // Recursively sort both halves
        ListNode leftHead = sortList(head);
        rightHead = sortList(rightHead);

        // Merge the sorted halves
        return merge(leftHead, rightHead);
    }

    public ListNode findMid(ListNode head) {
        // Initialize slow and fast pointers
        ListNode slow = head, fast = head;

        // Move slow by 1 step and fast by 2 steps until fast reaches the end
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // Slow will be at the middle
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        // Create a dummy node to simplify merging
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Merge the two sorted lists
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach the remaining nodes of l1 or l2
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }
}
