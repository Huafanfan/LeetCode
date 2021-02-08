package microsoft;

import java.util.HashMap;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/7 17:00
 *
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * Follow up:
 * Could you do get and put in O(1) time complexity?
 *
 */
public class LruCache0146 {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {};
        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;
    public LruCache0146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)){
            DLinkedNode cur = cache.get(key);
            moveToHead(cur);
            return cur.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)){
            DLinkedNode cur = cache.get(key);
            cur.value = value;
            moveToHead(cur);
        }
        else {
            DLinkedNode cur = new DLinkedNode(key, value);
            cache.put(key, cur);
            size++;
            addToHead(cur);
            if (size>capacity){
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                size--;
            }
        }
    }

    private void moveToHead(DLinkedNode cur){
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        addToHead(cur);
    }

    private void addToHead(DLinkedNode cur) {
        cur.prev = head;
        cur.next = head.next;
        head.next.prev = cur;
        head.next = cur;
    }

    private DLinkedNode removeTail(){
        DLinkedNode res = tail.prev;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        return res;
    }
}
