package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int count = 0;
        for(List<V> v: map.values()){
            for(V value: v){
                count++;
            }
        }
        return count;
    }

    @Override
    public V put(K key, V value) {
        List<V> arrayList = map.get(key);
        if(arrayList == null){
            arrayList = new ArrayList<>();
            map.put(key, arrayList);
        }
        if(arrayList.size() < repeatCount){
            map.get(key).add(value);
        }else{
            map.get(key).remove(0);
            map.get(key).add(value);
        }
        if(arrayList.size() > 1) {
            return arrayList.get(arrayList.size() - 2);
        }
        else{
            return null;
        }
    }

    @Override
    public V remove(Object key) {
        if(map.containsKey(key)){
            V value = null;
            value = map.get(key).remove(0);
            if(map.get(key).size() == 0){
                map.remove(key, map.get(key));
            }
            return value;
        }else{
            return null;
        }
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> arrayList = new ArrayList<>();
        for(List<V> v: map.values()){
            for(V value: v){
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        boolean tf = false;
        for(List<V> v: map.values()){
            for(Object result: v){
                if(result.equals(value))
                    tf = true;
            }
        }
        return tf;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}