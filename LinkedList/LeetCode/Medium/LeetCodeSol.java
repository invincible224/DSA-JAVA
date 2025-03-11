// List has loop or not

// public boolean hasCycle(ListNode head) {
//     if(head==null || head.next==null){return false;}

//     ListNode fast,slow;
//     slow=fast=head;
//     while(fast!=null && fast.next!=null){
//         slow=slow.next;
//         fast=fast.next.next;

//         if(fast==slow){return true;}
//     }
//     return false;
// }   


// Length of loop
// class Solution
// {
//     //Function to find the length of a loop in the linked list.
//     static int countNodesinLoop(Node head)
//     {
//         //Add your code here.
        
//         if(head==null || head.next==null){return 0;}
//         int count=0;
//         Node fast,slow;
//         slow=fast=head;
//         while(fast!=null && fast.next!=null){
//             slow=slow.next;
//             fast=fast.next.next;
            
//             if(fast==slow){
//                 return length(slow,fast);
//             }
//         }
//         return 0;
//     }
//     public static int length(Node slow,Node fast){
//         int count=1;
//         fast=fast.next;
//         while(slow!=fast){
//             count++;
//             fast=fast.next;
//         }
//         return count;
//     }
// }
    