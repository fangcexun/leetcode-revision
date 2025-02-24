package hot100.linkedList;

import java.util.HashMap;
import java.util.Map;

public class LC146 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        lruCache.put(4,4);
    }

}
class LRUCache {

    static class Node {
        Node prev;
        Node next;

        int key;
        int value;

        Node() {

        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node dummyHead;
    Node dummyTail;

    int capacity;

    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dummyHead = new Node();
        this.dummyTail = new Node();

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        } else if (map.size() == capacity) {
            remove(dummyTail.prev);
        }

        insert(new Node(key, value));
    }

    private void insert(Node node) {
        dummyHead.next.prev = node;
        node.next = dummyHead.next;

        dummyHead.next = node;
        node.prev = dummyHead;

        map.put(node.key, node);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = null;
        node.prev = null;

        map.remove(node.key);
    }
}