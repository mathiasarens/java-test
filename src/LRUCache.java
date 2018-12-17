import java.util.*;
/*
https://leetcode.com/problems/lru-cache/
 */

public class LRUCache {
    private LinkedHashMap<String, Integer> lru = new LinkedHashMap<>();
    private int capacity;

    public void put(final String key, final Integer value) {
        if (lru.containsKey(key)) {
            lru.remove(key);
        } else if (lru.size() >= capacity) {
            Iterator<String> it = lru.keySet().iterator();
            it.next();
            it.remove();
        }
        lru.put(key, value);
    }

    public int get(final String key) {
        final Integer value = lru.get(key);
        if (value == null) {
            return -1;
        } else {
            this.put(key, value);
            return value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String args[]) {
        // enable assert vm options with -ea
        final LRUCache lruCache = new LRUCache(2);
        lruCache.put("one", 1);
        lruCache.put("two", 2);
        assert(lruCache.get("two")==2);
        lruCache.put("three", 3);
        assert(lruCache.get("one")==-1);
        assert(lruCache.get("three")==3);
        assert(lruCache.get("two")==2);
        lruCache.put("four", 4);
        assert(lruCache.get("one")==-1);
        assert(lruCache.get("three")==-1);
        assert(lruCache.get("two")==2);
        assert(lruCache.get("four")==4);
        lruCache.put("five", 5);
        assert(lruCache.get("one")==-1);
        assert(lruCache.get("three")==-1);
        assert(lruCache.get("two")==-1);
        assert(lruCache.get("four")==4);
        assert(lruCache.get("five")==5);
    }
}




