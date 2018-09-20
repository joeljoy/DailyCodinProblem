//Implement an LRU (Least Recently Used) cache. It should be able to be initialized with a cache size n, and contain the following methods:
//
//        set(key, value): sets key to value. If there are already n items in the cache and we are adding a new item, then it should also remove the least recently used item.
//        get(key): gets the value at key. If no such key exists, return null.
//        Each operation should run in O(1) time.

import java.util.HashMap;
import java.util.Map;

public class LruCache {

    class Node {
        int key, value;
        Node pre, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> cache = new HashMap<>();
    Node head = null;
    Node tail = null;
    int capacity;

    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    public Node get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            setHead(node);
            return node;
        } else {
            return null;
        }
    }

    private void setHead(Node node) {
        node.pre = null;
        node.next = head;

        if (head != null) {
            head.pre = node;
        }
        head = node;

        if (tail == null) {
            tail = head;
        }
    }

    private void remove(Node node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            tail = node.pre;
        }
    }

    private void setKey(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            setHead(node);
        } else {
            Node created = new Node(key, value);
            if (capacity <= cache.size()) {
                remove(tail);
                setHead(created);
            } else {
                setHead(created);
            }

            cache.put(key, created);
        }
    }
}
