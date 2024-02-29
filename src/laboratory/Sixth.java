package laboratory;

import java.util.ArrayList;

public class Sixth {
    public static void main(String[] args) {
        //5.Написати програму, яка знаходить мінімальний та максимальний елементи двовимірного масиву.
        int[][] matrix = {
            {2, 7, 1000, 500, 10, 20145155},
            {5, 5, 7, 70, 700, 1010101}
        };

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                arrayList.add(matrix[i][j]);
            }
        }
        int minimal = Integer.MAX_VALUE;
        for(int min: arrayList){
            minimal = Math.min(minimal, min);
        }

        int maximal = Integer.MIN_VALUE;
        for(int min: arrayList){
            maximal = Math.max(maximal, min);
        }

        System.out.println("Min element: " + minimal);
        System.out.println("Max element " + maximal);
    }
}
