package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {
    }

    static {
        reset();
    }

    public static CanFly result;

    public static void reset() {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            String CanFly = bufferedReader.readLine();
            if(CanFly.equals("helicopter")){
                result = new Helicopter();
            }else if(CanFly.equals("plane")){
                result = new Plane(120);
            }

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
