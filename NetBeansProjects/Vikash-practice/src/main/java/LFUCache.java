public interface LFUCache {
    int get(int key);
    void put(int key, int value);
}
