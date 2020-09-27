package LikedList;

import java.util.HashMap;

/**
 * @Author LX
 * @Date 2020/9/24 13:47
 * @Description
 */
class LRUCache {

    class DNode {
        int key;
        int val;
        DNode prev;
        DNode next;

        public DNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public DNode() {
        }
    }


    private int length;
    private final int maxLength;

    HashMap<Integer, DNode> cache = new HashMap<>();

    private DNode first;
    private DNode last;

    public LRUCache(int capacity) {
        maxLength = capacity;
        first = new DNode();
        last = new DNode();
        first.next = last;
        last.prev = first;
    }

    public int get(int key) {
        DNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }


    public void put(int key, int value) {
        DNode node = cache.get(key);
        if (node != null) {
            node.val = value;
            moveToHead(node);
            return;
        }
        node = new DNode(key, value);
        addFirstNode(node);
        cache.put(key, node);
        if (++length > maxLength) {
            cache.remove(removeLast().key);
            length--;
        }
    }

    private void moveToHead(DNode node) {
        delNode(node);
        addFirstNode(node);
    }

    private void addFirstNode(DNode node) {
        node.prev = first;
        node.next = first.next;
        first.next.prev = node;
        first.next = node;
    }

    public DNode removeLast() {
        DNode node = last.prev;
        delNode(node);
        return node;
    }

    private void delNode(DNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    public void print() {
        StringBuilder builder = new StringBuilder();
        DNode node = first;
        while (node != null) {
            if (node.key != 0 && node.val != 0) {
                builder.append("(" + node.key + "," + node.val + ")-¡·");
            }
            node = node.next;

        }
        System.out.println(builder.toString() + ("size=" + length));
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);
        lruCache.put(1, 1);
        lruCache.print();
        lruCache.put(2, 2);
        lruCache.print();
        lruCache.put(3, 3);
        lruCache.print();
        lruCache.put(4, 4);
        lruCache.print();
        lruCache.get(1);
        lruCache.print();
        lruCache.put(5, 5);
        lruCache.print();
        lruCache.put(1, 2);
        lruCache.print();
    }

}
