package com.javarush.task.task33.task3310.strategy;

import java.util.Objects;

public class OurHashMapStorageStrategy implements StorageStrategy{
    private  static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    private int size;
    private int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    private float loadFactor = DEFAULT_LOAD_FACTOR;

    public int hash(Long k){
        return Objects.hashCode(k);
    }
    public int indexFor(int hash, int length){
        return hash & (length - 1);
    }
    public Entry getEntry(Long key){
        for(Entry entry: table){
            if(entry.key.equals(key))
                return entry;
        }
        return null;
    }

    public void resize(int newCapacity){
        Entry[] entry = new Entry[newCapacity];
        transfer(entry);
        table = entry;
        threshold = (int) (newCapacity * loadFactor);
    }
    public void transfer(Entry[] newTable){
        for (int i = 0; i < table.length; i++) {
            newTable[i] = table[i];
        }
    }
    public void addEntry(int hash, Long key, String value, int bucketIndex){
        Entry entry = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, entry);
        if(size++ >= table.length){
            resize(10 + table.length);
        }

    }
    public void createEntry(int hash, Long key, String value, int bucketIndex){
        Entry next = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, next);
        size++;
    }
    @Override
    public boolean containsKey(Long key) {
        boolean tf = false;
        for(Entry entry: table){
            if(entry.getKey().equals(key))
                tf = true;
        }
        return tf;
    }

    @Override
    public boolean containsValue(String value) {
        for (Entry tableElement : table)
            for (Entry e = tableElement; e != null; e = e.next)
                if (value.equals(e.value))
                    return true;
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        for (Entry e = table[index]; e != null; e = e.next) {
            if (key.equals(e.key)) {
                e.value = value;
                return;
            }
        }
        addEntry(hash, key, value, index);
    }

    @Override
    public Long getKey(String value) {
        for (Entry tableElement : table)
            for (Entry e = tableElement; e != null; e = e.next)
                if (value.equals(e.value))
                    return e.getKey();
        return null;
    }

    @Override
    public String getValue(Long key) {
        for(Entry forValue: table){
            for(Entry e = forValue; e != null; e = e.next){
                if(key.equals(e.key)){
                    return e.value;
                }
            }
        }
        return null;
    }
}
