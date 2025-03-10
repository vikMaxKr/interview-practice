/*
Design and implement a data structure for a Least Frequently Used (LFU) cache.
Implement the LFUCache class:
LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present.
 When the cache reaches its capacity,
it should invalidate and remove the least frequently used key before inserting a new item.
To determine the least frequently used key, a use counter is maintained for each key in the cache.
The key with the smallest use counter is the least frequently used key.
When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation).
The use counter for a key in the cache is incremented; either a get or put operation is called on it.

Explanation
LFUCache lfu = new LFUCache(2);
lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
lfu.get(1);      // return 1
                 // cache=[1,2], cnt(2)=1, cnt(1)=2
lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                 // cache=[3,1], cnt(3)=1, cnt(1)=2
lfu.get(2);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,1], cnt(3)=2, cnt(1)=2
lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                 // cache=[4,3], cnt(4)=1, cnt(3)=2
lfu.get(1);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,4], cnt(4)=1, cnt(3)=3
lfu.get(4);      // return 4
                 // cache=[4,3], cnt(4)=2, cnt(3)=3

—---------------

 */

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LRUCacheConcrete implements LFUCache {


    Map<Integer,Integer> map;
    Map<Integer, Integer> counter=new HashMap<>();
    int capacity=0;
    void LRUCache(int capacity)
    {
        map=new HashMap<>(capacity);
        this.capacity=capacity;
    }


    @Override
    public int get(int key) {
        if(map.containsKey(key))
        {
            counter.put(key, counter.getOrDefault(key, 0)+1);
            return map.get(key);
        }
        return -1;
    }

    @Override
    public void put(int key, int value) {

        if(map.size()==capacity)
        {
            int min=Integer.MAX_VALUE;
            int newKey=0;
           for(Map.Entry<Integer,Integer> count: counter.entrySet())
           {
               int tempKey=count.getKey();
               int tempValue=count.getValue();

               if(tempValue< min)
               {
                   min=tempValue;
                   newKey=tempKey;
               }
           }

           if(map.containsKey(newKey))
           {
               map.remove(newKey);
           }
        }
        map.put(key, value);
        counter.put(key, counter.getOrDefault(key, 0)+1);
    }


}
