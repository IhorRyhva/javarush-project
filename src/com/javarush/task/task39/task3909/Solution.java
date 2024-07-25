package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    @Test
    public void isOneEditAwayTest() {
        Assert.assertTrue(Solution.isOneEditAway("letter", "letter"));
        Assert.assertFalse(Solution.isOneEditAway("leTTer", "letter"));
        Assert.assertTrue(Solution.isOneEditAway("leter", "letter"));
        Assert.assertTrue(Solution.isOneEditAway("letterA", "letterB"));
        Assert.assertTrue(Solution.isOneEditAway("letterA", "letter"));
        Assert.assertTrue(Solution.isOneEditAway("letter", "letterB"));
        Assert.assertFalse(Solution.isOneEditAway("letter", "letterBB"));
        Assert.assertFalse(Solution.isOneEditAway("leTter", "letterB"));
        Assert.assertTrue(Solution.isOneEditAway("A", "B"));
        Assert.assertTrue(Solution.isOneEditAway("A", ""));
        Assert.assertTrue(Solution.isOneEditAway("", ""));
    }
    public static void main(String[] args) {
        System.out.println(isOneEditAway("letter", "lestter"));//true
    }

    public static boolean isOneEditAway(String first, String second) {
        if (first.isEmpty() || second.isEmpty()) {
            return true;
        }
        char[] firstArray = first.toCharArray();
        char[] secondArray = second.toCharArray();
        if(firstArray.length == secondArray.length){
            int count = 0;
            for (int i = 0; i < secondArray.length; i++) {
                if(firstArray[i] != secondArray[i]) {
                    count++;
                }
            }
            return count < 2;
        }else if(Math.max(firstArray.length, secondArray.length) - Math.min(secondArray.length, firstArray.length) == 1){
//            int length = Math.min(firstArray.length, secondArray.length);
//            int count = 0;
//            for (int i = 0; i < length; i++) {
//                if(firstArray[i] != secondArray[i]) {
//                    if(i == 0) {
//                        count++;
//                    }else if(firstArray.length > secondArray.length) {
//                        if (firstArray[i + 1] != secondArray[i])
//                            count++;
//                    }else{
//                        if (firstArray[i] != secondArray[i + 1])
//                            count++;
//                    }
//                }
//            }
//            return count < 1;
            if(firstArray.length > secondArray.length) {
                return checkInsertion(first, second);
            }else{
                return checkInsertion(second, first);
            }
        }else{
            return false;
        }
    }
    private static boolean checkInsertion(String first, String second) {
        int i = 0;
        int j = 0;

        while (j < second.length() && i < first.length()) {
            if (first.charAt(i) != second.charAt(j)) {
                if (i != j) {
                    return false;
                }
                i++;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }
}