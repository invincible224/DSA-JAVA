package LinkedList.Medium;

import LinkedList.Medium.OddEvenList.ListNode;

public class MergeTwoSortedLists {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            // Dummy node to simplify edge cases
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;
    
            // Merge lists while both are non-empty
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    curr.next = list1;  // Point to the current node in list1
                    list1 = list1.next; // Move to the next node in list1
                } else {
                    curr.next = list2;  // Point to the current node in list2
                    list2 = list2.next; // Move to the next node in list2
                }
                curr = curr.next; // Move to the next position in the merged list
            }
    
            // Attach the remaining nodes of list1 or list2
            if (list1 != null) {
                curr.next = list1;
            } else if (list2 != null) {
                curr.next = list2;
            }
    
            // Return the merged list starting from dummy.next
            return dummy.next;
        }    
}
