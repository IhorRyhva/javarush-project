package laboratory;

import java.util.Scanner;

public class Fifth {
    public static void main(String[] args) {
        //6.	Написати функцію, яка повертає 1, якщо отриманий функцією у якості аргумента символ є великою буквою англійської абетки
        //і 0 – у протилежному випадку.

        Scanner scanner = new Scanner(System.in);
        System.out.println(isLowerCaseOrUperCase(scanner.nextLine().charAt(0)));
    }

    private static int isLowerCaseOrUperCase(char c) {
        if(Character.isUpperCase(c)){
            return 1;
        }else if(Character.isLowerCase(c)){
            return 0;
        }else{
            return 0;
        }
    }
}

