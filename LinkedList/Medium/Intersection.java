package LinkedList.Medium;

import LinkedList.Medium.OddEvenList.ListNode;

public class Intersection {


// Optimal solution : TC = O(m + n)  SC = O(1)
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // If either of the heads is null, there's no intersection.
    if (headA == null || headB == null) return null;

    // Initialize two pointers, `a` starting at headA and `b` starting at headB.
    ListNode a = headA;
    ListNode b = headB;

    // Traverse the lists with two pointers.
    // The goal is to synchronize their traversal lengths by switching heads.
    while (a != b) { // Loop until the two pointers meet or both become null.
        // If pointer `a` reaches the end of list A, switch it to head of list B.
        // This compensates for the difference in lengths of the two lists.
        if (a == null) {
            a = headB;
        } else {
            a = a.next; // Otherwise, move `a` to the next node in its list.
        }

        // If pointer `b` reaches the end of list B, switch it to head of list A.
        // Again, this ensures both pointers traverse the same total length.
        if (b == null) {
            b = headA;
        } else {
            b = b.next; // Otherwise, move `b` to the next node in its list.
        }
    }

    // The loop ends when `a` equals `b`. If they meet, that's the intersection node.
    // If no intersection exists, both pointers will eventually become null.
    return a; 
}

}


// --------------Brute force approach
/*public ListNode getIntersectionNodeBrute(ListNode headA, ListNode headB) {
    // If either list is null, there's no intersection.
    if (headA == null || headB == null) return null;

    // For each node in list A, compare it with all nodes in list B.
    ListNode a = headA;
    while (a != null) {
        ListNode b = headB;
        while (b != null) {
            if (a == b) {
                return a; // Return the intersection node when found.
            }
            b = b.next;
        }
        a = a.next;
    }

    // If no intersection is found, return null.
    return null;
}
 */


//  -----------Better approach
/*

public ListNode getIntersectionNodeHashing(ListNode headA, ListNode headB) {
    // If either list is null, there's no intersection.
    if (headA == null || headB == null) return null;

    // Use a HashSet to store nodes of list A.
    HashSet<ListNode> nodes = new HashSet<>();
    ListNode a = headA;

    // Add all nodes of list A to the HashSet.
    while (a != null) {
        nodes.add(a);
        a = a.next;
    }

    // Traverse list B and check if any node is already in the HashSet.
    ListNode b = headB;
    while (b != null) {
        if (nodes.contains(b)) {
            return b; // Return the intersection node when found.
        }
        b = b.next;
    }

    // If no intersection is found, return null.
    return null;
}
 */