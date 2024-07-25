package com.javarush.task.task33.task3310.strategy;

import java.util.Objects;

public class FileStorageStrategy implements StorageStrategy{

    private static final int DEFAULT_INITIAL_CAPACITY = 16; // Ёмкость по умолчанию
    private static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000; // Предельный размер ведра (10 килобайт)
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY]; // Хэш-таблица
    private int size; // Количество записей
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT; // Тоже предельный размер ведра, только менять можно
    long maxBucketSize; // ????
    public FileStorageStrategy() {
        init();
    }

    private void init() {
        table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
        for (int i = 0; i < table.length; i++) {
            table[i] = new FileBucket();
        }
    }
    public int hash(Long k){
        return Objects.hashCode(k);
    }
    public int indexFor(int hash, int length){
        return hash & (length - 1);
    }
    public Entry getEntry(Long key){
        if (size == 0) {
            return null;
        }

        int index = indexFor(key.hashCode(), table.length);
        for (Entry entry = table[index].getEntry(); entry != null; entry = entry.next) {
            if (key.equals(entry.key)) {
                return entry;
            }
        }
        return null;
    }
    public void resize(int newCapacity){
        FileBucket[] buckets = new FileBucket[newCapacity];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new FileBucket();
        }
        transfer(buckets);
        for (int i = 0; i < table.length; i++) {
            table[i].remove();
        }

        table = buckets;
    }
    public void transfer(FileBucket[] newTable){
        int length = newTable.length;
        for(FileBucket bucket: table){
            Entry entry = bucket.getEntry();
            while (entry != null){
                Entry next = entry.next;
                int index = indexFor(entry.getKey().hashCode(), length);
                entry.next = newTable[index].getEntry();
                newTable[index].putEntry(entry);
                entry = next;
            }
            maxBucketSize = Math.max(maxBucketSize, bucket.getFileSize());
        }
    }
    public void addEntry(int hash, Long key, String value, int bucketIndex){
        if(maxBucketSize > bucketSizeLimit){
            resize(table.length*2);
            bucketIndex = indexFor(key.hashCode(), table.length);
        }
        createEntry(hash, key, value, bucketIndex);
    }
    public void createEntry(int hash, Long key, String value, int bucketIndex){
        Entry entry = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, entry));
        size++;
        long currentBucketSize = table[bucketIndex].getFileSize();
        if (currentBucketSize > maxBucketSize)
            maxBucketSize = currentBucketSize;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }
    @Override
    public boolean containsValue(String value) {
        for (FileBucket tableElement : table) {
            for (Entry e = tableElement.getEntry(); e != null; e = e.next)
                if (value.equals(e.value))
                    return true;
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = key.hashCode();
        int index = indexFor(hash, table.length);
        for (Entry e = table[index].getEntry(); e != null; e = e.next) {
            if (key.equals(e.key)) {
                e.value = value;
                return;
            }
        }
        addEntry(hash, key, value, index);
    }

    @Override
    public Long getKey(String value) {
        for (FileBucket tableElement : table)
            for (Entry e = tableElement.getEntry(); e != null; e = e.next)
                if (value.equals(e.value))
                    return e.getKey();
        return null;
    }

    @Override
    public String getValue(Long key) {
        Entry entry = getEntry(key);
        if (entry != null)
            return entry.getValue();

        return null;
    }
    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }
}
