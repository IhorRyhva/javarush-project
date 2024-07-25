package com.javarush.task.task20.task2017;

import java.io.*;

/* 
Десериализация
*/

public class Solution implements Serializable{
    public A getOriginalObject(ObjectInputStream objectStream){
        A a = null;
        try{
            Object object = objectStream.readObject();
            if(!(object instanceof B)) {
                a = (A) object;
            }
        } catch (Exception e) {
            System.out.println("null");
            a = null;
        }
        if(a != null)
            System.out.println("Cool work");
        return a;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) throws IOException {
        B a = new Solution().new B();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream output = new ObjectOutputStream(outputStream);
        output.writeObject(a);
        output.flush();
        A aa = new Solution().getOriginalObject(new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())));
        System.out.println(aa);
        System.out.println(a);
    }
}
