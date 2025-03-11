package DoublyLL;

class DLLNode{
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int data){
        this.data = data;
        next = null;
        prev = null;
    }
}

public class Reverse {
    public DLLNode reverseDLL(DLLNode head) {
        // Your code here
        if (head == null || head.next == null) {
            return head;
        }

        DLLNode last = null;
        DLLNode curr = head;

        while (curr != null) {
            DLLNode nextnode = curr.next;
            curr.next = last;
            curr.prev = nextnode;

            last = curr;
            curr = nextnode;
        }

        return last;
    }

    public DLLNode reverse(DLLNode head) {
        // Your code here
        if (head == null || head.next == null) {
            return head;
        }

        DLLNode last = null;
        DLLNode curr = head;

        while (curr != null) {
            last = curr.prev;
            curr.prev = curr.next;
            curr.next = last;
            curr = curr.prev;
        }

        return last.prev;
    }
}

class rev {

}
