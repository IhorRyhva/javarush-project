package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/

public class Solution implements Serializable {
    public static class SubSolution extends Solution{
        public SubSolution() throws NotSerializableException {
           throw new NotSerializableException();
        }
    }

    public static void main(String[] args) throws IOException {
        SubSolution solution = new SubSolution();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(solution);
    }
}
