public class SwapPairsDLL {
    public void swapPairs(){
        if(head == null || head.next == null){
            return;
        }
        
        Node temp = head;

        // Traverse the list and swap pairs
        while (temp != null && temp.next != null) {
            Node node1 = temp;
            Node node2 = temp.next;

        
            if (node1 == head) {
                head = node2;
            }

            
            swap(node1, node2);

            temp = node1.next;
    }
    
     
}
public void swap(Node node1, Node node2){
        if (node1.prev != null) {
            node1.prev.next = node2;
        }
        if (node2.next != null) {
            node2.next.prev = node1;
        }

        // Swap the nodes
        node1.next = node2.next;
        node2.prev = node1.prev;
        node1.prev = node2;
        node2.next = node1;
    }
}
