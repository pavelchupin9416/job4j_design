package cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public final void put(K key, V value) {
        SoftReference temp = new SoftReference<>(value);
        if (!cache.containsKey(key)) {
            cache.put(key, temp);
        }
    }

    public final V get(K key) {
        V temp = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (temp == null) {
            temp = this.load(key);
            put(key, temp);
        }
        return temp;
    }

    protected abstract V load(K key);
}

