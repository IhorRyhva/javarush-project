package com.javarush.task.pro.task13.task1313;

public class StringLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {

            if(first.next == null){
                Node newAdd = new Node();
                newAdd.value = value;
                first.next = newAdd;

            }
            if(last.prev == null){
                last.prev = first.next;
                return;
            }

            Node newAdd = new Node();
            newAdd.value = value;

            Node lastPrev = last.prev;
            lastPrev.next = newAdd;
            newAdd.prev = lastPrev;
            newAdd.next = last;
            last.prev = newAdd;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
