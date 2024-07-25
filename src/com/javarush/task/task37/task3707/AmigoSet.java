package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    final static private Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet(){
        map = new HashMap<>();
    }
    public AmigoSet(Collection<? extends E> collection){
        int capacity = Math.max(16, (int) (collection.size()/.75f) + 1);
        map = new HashMap<>(capacity);
        addAll(collection);
    }
    @Override
    public Object clone(){
        try {
            AmigoSet<E> amigoSet = new AmigoSet<>();
            amigoSet.map = (HashMap<E, Object>) map.clone();
            return amigoSet;
        }catch (Exception e){
            throw new InternalError();
        }
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }


    @Override
    public int size() {
        return map.size();
    }
    public boolean isEmpty(){
        return map.isEmpty();
    }

    public boolean contains(Object o){
        return map.containsKey(o);
    }

    public void clear(){
        map.clear();
    }

    public boolean remove(Object o){
        map.remove(o);
        return true;
    }
    public boolean add(E e){
        if(map.containsKey(e)){
            return false;
        }else{
            map.put(e, PRESENT);
            return true;
        }
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();

        outputStream.writeInt(map.size());
        //outputStream.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity()"));
        //outputStream.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor()"));

        for(Map.Entry<E, Object> res: map.entrySet()){
            outputStream.writeObject(res.getKey());
        }
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        int size = inputStream.readInt();
        //int capacity = inputStream.readInt();
        //float loadFactor = inputStream.readFloat();
        map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            map.put((E) inputStream.readObject(), PRESENT);
        }
    }
}
