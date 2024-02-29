package laboratory;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        //15.	Знайти середнє арифметичне п’яти цілих чисел.
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];
        for (int i = 0; i < 5; i++) {
            array[i] = scanner.nextInt();
        }

        double res = 0;
        for (int i = 0; i < 5; i++) {
            res += array[i];
        }

        System.out.println("Result " + res/5);
    }
}
