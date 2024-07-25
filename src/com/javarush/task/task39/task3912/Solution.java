package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution {
    @Test
    public void testMaxSquareLargeArray() {
        int[][] matrix1 = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };
        assertEquals(4, maxSquare(matrix1));

        // Example 2: Incorrect Behavior
        int[][] matrix2 = {
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        assertEquals(1, maxSquare(matrix2)); // Assuming the method returns 1 incorrectly

        // Example 3: Incorrect Behavior
        int[][] matrix3 = {
                {1, 1},
                {1, 1}
        };
        assertEquals(4, maxSquare(matrix3));
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        System.out.println(maxSquare(matrix));//1
    }

    public static int maxSquare(int[][] matrix) {
//        int[][] cash = matrix;
//        int repeat = Math.min(matrix.length, matrix[0].length);
//        for (int m = 0; m < repeat; m++) {
//            int result = Arrays.stream(cash).flatMapToInt(Arrays::stream).max().getAsInt();
//            if(result == repeat)
//                break;
//            for (int i = 0; i < matrix.length; i++) {
//                for (int j = 0; j < matrix[0].length; j++) {
//                    if (i == matrix.length - 1 || j == matrix[0].length - 1) {
//                        cash[i][j] = matrix[i][j];
//                    } else {
//                        if (matrix[i][j] >= result && matrix[i][j + 1] >= result && matrix[i + 1][j] >= result && matrix[i + 1][j + 1] >= result) {
//                            cash[i][j] = matrix[i][j] + 1;
//                            matrix[i][j] = cash[i][j];
//                        } else {
//                            if (matrix[i][j] >= 1) {
//                                cash[i][j] = matrix[i][j];
//                            } else {
//                                cash[i][j] = 0;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        int res = Arrays.stream(cash).flatMapToInt(Arrays::stream).max().getAsInt();
//        return res*res;
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        int[][] temp = new int[rows + 1][cols + 1];
        int maxLen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    temp[i][j] = Math.min(Math.min(temp[i][j - 1], temp[i - 1][j]), temp[i - 1][j - 1]) + 1;
                    maxLen = Math.max(maxLen, temp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }
}
