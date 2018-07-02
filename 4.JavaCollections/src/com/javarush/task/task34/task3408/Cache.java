package com.javarush.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        if (!cache.containsKey(key))
            cache.put(key, clazz.getConstructor(key.getClass()).newInstance(key));

        return cache.get(key);
    }

    public boolean put(V obj) {
        //TODO add your code here
        Method m;
        try {
            m = obj.getClass().getDeclaredMethod("getKey");
            m.setAccessible(true);
            K key = (K) m.invoke(obj, null);
            cache.put(key, obj);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            return false;
        }

        return true;
    }

    public int size() {
        return cache.size();
    }
}
