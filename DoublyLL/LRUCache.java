package DoublyLL;
import java.util.*;


public class LRUCache {
    
    // Node class to represent each item in the doubly linked list
    class Node {
        int key, value;  // Stores key-value pair
        Node prev, next; // Pointers to previous and next nodes

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map;  // HashMap for O(1) lookup
    private int capacity;  // Maximum size of cache
    private Node head, tail;  // Dummy head & tail to manage LRU order

    // Constructor: Initializes cache with given capacity
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Creating dummy head & tail nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);
        
        // Connecting head and tail
        head.next = tail;
        tail.prev = head;
    }

    // Get the value of the key if it exists in cache, otherwise return -1
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;  // Key not found
        }

        Node node = map.get(key);  // Fetch the node
        remove(node);  // Remove node from its current position
        insert(node);  // Insert it at the front (most recently used)
        return node.value;  // Return value
    }

    // Put a key-value pair in the cache
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key)); // Remove old node if key already exists
        }

        if (map.size() == capacity) {
            remove(tail.prev); // Remove least recently used (LRU) node (last node)
        }

        insert(new Node(key, value)); // Insert new node at front
    }

    // Insert a node at the front (most recently used position)
    private void insert(Node node) {
        map.put(node.key, node);  // Store in HashMap
        
        // Adjust pointers to insert node right after head
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Remove a node from the linked list and HashMap
    private void remove(Node node) {
        map.remove(node.key);  // Remove from HashMap

        // Adjust pointers to unlink node from doubly linked list
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}


