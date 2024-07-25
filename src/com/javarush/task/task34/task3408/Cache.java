package com.javarush.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        V value = cache.get(key);
        if(value == null){
            value = clazz.getDeclaredConstructor(key.getClass()).newInstance(key);
            System.out.println(put(value));
        }
        return value;
    }

    public boolean put(V obj){
        try {
            Class clazz = Class.forName(obj.getClass().getName());
            Method method = clazz.getDeclaredMethod("getKey");
            method.setAccessible(true);
            K key = (K) method.invoke(obj);
            cache.put(key, obj);
            return true;
        } catch (ClassNotFoundException | IllegalAccessException e) {
            return false;
        } catch (NoSuchMethodException | InvocationTargetException e) {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}
