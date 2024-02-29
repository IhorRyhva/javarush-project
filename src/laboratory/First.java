package laboratory;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int grn = scanner.nextInt();
        count(grn);
    }

    public static void count(int grn){
        System.out.println("Euro: " + grn*40);
        System.out.println("Dolar: " + grn*37);
    }
}
