package com.javarush.task.pro.task13.task1314;

public class StringLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    //private int count = 0;

    public void add(String value) {
        if (first.next == null) {
            Node node = new Node();
            node.value = value;
            first.next = node;
        }
        if (last.prev == null) {
            last.prev = first.next;
            return;
        }

        Node node = new Node();
        node.value = value;

        Node lastNode = last.prev;
        lastNode.next = node;
        node.prev = lastNode;
        last.prev = node;
        //count++;
    }

    public String get(int index) {
        String st = null;
//        if(index <= count) {
//            Node forUse = first;
//            for (int i = 0; i <= index; i++) {
//                forUse = forUse.next;
//            }
//            if (forUse != null) {
//                st = forUse.value;
//            }
//        }
        Node forUse = first;
        for (int i = 0; i <= index; i++) {
            if(forUse.next != null){
                forUse = forUse.next;
                st = forUse.value;
            }else{
                st = null;
                break;
            }
        }
        return st;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
