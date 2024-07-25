package com.javarush.task.task38.task3804;

public class Factory {
    public static Throwable getException(Enum message){
        if((message instanceof UserExceptionMessage) || message instanceof DatabaseExceptionMessage || message instanceof  ApplicationExceptionMessage) {
            String s = message.toString();
            int index = s.lastIndexOf("e") + 1;
            s = s.substring(index);
            String result = "";
            char[] array = s.toCharArray();
            result += array[0];
            for (int i = 1; i < array.length; i++) {
                if(array[i] == '_'){
                    array[i] = ' ';
                }else{
                    array[i] = Character.toLowerCase(array[i]);
                }
                result += array[i];
            }
            if (message instanceof UserExceptionMessage) {
                //System.out.println(result);
                return new Error(result);
            } else if (message instanceof  DatabaseExceptionMessage) {
                //System.out.println(result);
                return new RuntimeException(result);
            } else if (message instanceof ApplicationExceptionMessage) {
                //System.out.println(result);
                return new Exception(result);
            }
        }else{
            return new IllegalArgumentException();
        }
        return null;
    }

}
