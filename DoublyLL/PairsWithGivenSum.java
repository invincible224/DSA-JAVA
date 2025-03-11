package DoublyLL;

import java.util.ArrayList;

// Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.
/*Input:  
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
target = 7
Output: (1, 6), (2,5)
Explanation: We can see that there are two pairs 
(1, 6) and (2,5) with sum 7. */

public class PairsWithGivenSum {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // Handle edge case when head is null
        if (head == null) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Node temp = head;
        Node tail = null;

        // Find the tail of the doubly linked list
        while (temp.next != null) {
            temp = temp.next;
        }
        tail = temp;
        temp = head;

        // Two-pointer approach to find pairs
        while (temp != null && tail != null && temp != tail && temp.prev != tail) {
            int sum = temp.data + tail.data;

            if (sum > target) {
                tail = tail.prev;
            } else if (sum < target) {
                temp = temp.next;
            } else {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(temp.data);
                pair.add(tail.data);
                ans.add(pair);

                temp = temp.next;
                tail = tail.prev;
            }
        }
        return ans;
    }
}
