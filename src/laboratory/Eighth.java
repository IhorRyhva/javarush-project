package laboratory;

public class Eighth {
    public static void main(String[] args) {
        //8.Написати програму, яка обчислює середнє арифметичне елементів двовимірного масиву
        //без врахування мінімального та максимального елементів.
        int[][] array = {
                {10, 100, 852, 5},
                {878, 5145, 74},
                {8, 8, 5, 40, 22, 23, 21}
        };
        int length = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            length += array[i].length;
        }

        int[] result = new int[length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result[count] = array[i][j];
                count++;
            }
        }

        int expression = 0;
        for (int i = 0; i < length; i++) {
            expression += result[i];
        }

        System.out.println(expression/length);
    }
}
