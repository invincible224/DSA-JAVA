package LinkedList.Hard;

import java.util.ArrayList;
import java.util.Collections;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.bottom = null;
    }
}

public class FlattenLL {

    public Node flatten(Node root) {
        if (root == null) {
            return null;
        }

        // Step 1: Traverse the list and collect all elements
        ArrayList<Integer> list = new ArrayList<>();
        Node temp = root;

        while (temp != null) {
            Node temp2 = temp;
            while (temp2 != null) {
                list.add(temp2.data);
                temp2 = temp2.bottom;
            }
            temp = temp.next;
        }

        // Step 2: Sort the list
        Collections.sort(list);

        // Step 3: Create a new flattened linked list
        Node dummy = new Node(0);
        Node curr = dummy;

        for (int value : list) {
            curr.bottom = new Node(value);
            curr = curr.bottom;
        }

        return dummy.bottom;
    }

}

// --------Optimal solution 
// Time Complexity: O(T), where T is the total number of nodes in the entire structure (including all next and bottom pointers).

// Space Complexity: O(N), where N is the number of nodes in the main linked list (due to recursion stack).
class Solution {
    // Function to flatten a linked list
    Node flatten(Node head) {
        // Base case: if head is null or there's no next node, return head
        if (head == null || head.next == null) {
            return head;
        }
        
        // Recursively flatten the next node
        Node mergedHead = flatten(head.next);
        
        // Merge the current node with the flattened next node
        return merge(head, mergedHead);
    }
    
    // Function to merge two linked lists
    Node merge(Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node curr = dummy;
        
        // Merge the two lists based on the data values
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                curr.bottom = l1;
                curr = l1;
                l1 = l1.bottom;
            } else {
                curr.bottom = l2;
                curr = l2;
                l2 = l2.bottom;
            }
        }
        
        // Attach the remaining elements of l1 or l2
        if (l1 != null) {
            curr.bottom = l1;
        } else {
            curr.bottom = l2;
        }
        
        // Ensure the next pointer is null
        dummy.bottom.next = null;
        
        return dummy.bottom;
    }
}