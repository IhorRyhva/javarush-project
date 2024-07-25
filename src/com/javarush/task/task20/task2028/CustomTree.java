package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    int count = 0;
    @Override
    public String get(int index){
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element){
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element){
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index){
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c){
        throw new UnsupportedOperationException();
    }



    @Override
    public int size() {
        return count;
    }
    ArrayList<Entry> name = new ArrayList<>();
    @Override
    public boolean add(String elementName){
        count++;
        Entry newEntry = new Entry<>(elementName);
        name.add(newEntry);
        Queue<Entry<String>> queue = new LinkedList<>();
        Entry<String> entry = root;
        queue.add(entry);
        while (!(entry=queue.poll()).isAvailableToAddChildren()){
            queue.add(entry.leftChild);
            queue.add(entry.rightChild);
        }
        if (entry.availableToAddLeftChildren) {
            entry.leftChild = newEntry;
            entry.availableToAddLeftChildren = false;
        } else {
            entry.rightChild = newEntry;
            entry.availableToAddRightChildren = false;
        }
        newEntry.parent = entry;
        return true;
    }

    public String getParent(String s){
        Entry result = new Entry<>("temp");
        for(Entry entry: name){
            if(entry.elementName.equals(s))
                result = entry.parent;
        }
        return result.elementName;
    }

    public boolean remove(Object o){
        // Перевірка, чи переданий об'єкт є строкою
        if (!(o instanceof String))
            throw new UnsupportedOperationException();

        // Конвертація переданого об'єкта в строку
        String link = (String) o;

        // Пошук елемента з іменем, яке дорівнює переданій строкі
        Entry entryToRemove = null;
        for (Entry entry : name) {
            if (entry.elementName.equals(link)) {
                entryToRemove = entry;
                break;
            }
        }

        // Якщо не було знайдено елемента з переданим ім'ям, повертаємо false
        if (entryToRemove == null)
            return false;

        // Видалення зв'язку між батьком та видаляємою дитиною, якщо вона є
        if (entryToRemove.parent != null) {
            if (entryToRemove.parent.leftChild == entryToRemove) {
                entryToRemove.parent.leftChild = null;
                entryToRemove.parent.availableToAddLeftChildren = true; // Відновлення можливості додавати лівого дитину батька
            } else if (entryToRemove.parent.rightChild == entryToRemove) {
                entryToRemove.parent.rightChild = null;
                entryToRemove.parent.availableToAddRightChildren = true; // Відновлення можливості додавати правого дитину батька
            }
        }

        // Черга для видалення всіх дочірніх елементів видаляємого елемента
        Queue<Entry> queue = new LinkedList<>();
        queue.add(entryToRemove);
        while (!queue.isEmpty()) {
            Entry current = queue.poll();
            if (current.leftChild != null) {
                queue.add(current.leftChild);
                current.leftChild.parent = null; // Видалення посилання на батька для лівої дитини
            }
            if (current.rightChild != null) {
                queue.add(current.rightChild);
                current.rightChild.parent = null; // Видалення посилання на батька для правої дитини
            }
            count--; // Зменшення лічильника кількості елементів
        }

        // Видалення видаляємого елемента зі списку
        name.remove(entryToRemove);
        return true; // Повертаємо true для підтвердження успішного видалення елемента
    }
    Entry root;

    public CustomTree() {
        root = new Entry<>("root");
    }

    static class Entry<T> implements Serializable{
        public boolean isParent(){
            Entry entry = this;
            boolean tf = false;
            if(entry.leftChild != null || entry.rightChild != null){
                tf = true;
            }
            return tf;
        }
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddRightChildren = true;
            availableToAddLeftChildren = true;
        }

        public boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}
