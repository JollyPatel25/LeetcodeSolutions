import java.util.HashMap;
import java.util.Map;

class LRUCache {
    
    // 1. Static inner class consumes minimal memory and prevents leaks
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 2. Core pillars are marked 'final' so their reference pointers can never be accidentally changed
    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        // Dummy boundary nodes protect us from messy null-pointer checks
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node node = map.get(key);
        moveToHead(node); // Move to front since it was recently accessed
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value; // Update the internal contents of the final map's node
            moveToHead(node);   // Refresh its priority
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNode(newNode);   // Connect right after the dummy head
            
            // If the cache overflows, evict the oldest entry
            if (map.size() > capacity) {
                Node lruNode = tail.prev; // The real element right before dummy tail
                removeNode(lruNode);
                map.remove(lruNode.key);  // Safely erase from lookups
            }
        }
    }

    // Helper: Snaps a node into the list directly after the dummy head (MRU)
    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        
        head.next.prev = node;
        head.next = node;
    }

    // Helper: Safely cuts a node out of the chain by stitching its neighbors together
    private void removeNode(Node node) {
        Node previousNode = node.prev;
        Node nextNode = node.next;
        
        previousNode.next = nextNode;
        nextNode.prev = previousNode;
    }

    // Helper: Pulls a node out of its current spot and slaps it to the absolute front
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

