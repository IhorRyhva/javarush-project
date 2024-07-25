package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Алгоритмы-числа
*/

public class Solution {
    public static final long[] ARMSTRONG_NUMBERS_LONG_LIMIT = {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1_634,
            8_208, 9_474, 54_748, 92_727, 93_084, 548_834, 1_741_725, 4_210_818, 9_800_817, 9_926_315, 24_678_050,
            24_678_051, 88_593_477, 146_511_208, 472_335_975, 534_494_836, 912_985_153, 4_679_307_774L, 32_164_049_650L,
            32_164_049_651L, 40_028_394_225L, 42_678_290_603L, 44_708_635_679L, 49_388_550_606L, 82_693_916_578L,
            94_204_591_914L, 28_116_440_335_967L, 4_338_281_769_391_370L, 4_338_281_769_391_371L, 21_897_142_587_612_075L,
            35_641_594_208_964_132L, 35_875_699_062_250_035L, 1_517_841_543_307_505_039L, 3_289_582_984_443_187_032L,
            4_498_128_791_164_624_869L, 4_929_273_885_928_088_826L};

    public static long[] getNumbers(long N) {
        ArrayList<Long> forResult = new ArrayList<>();
        for (int i = 0; i < ARMSTRONG_NUMBERS_LONG_LIMIT.length; i++) {
            if(ARMSTRONG_NUMBERS_LONG_LIMIT[i] < N){
                forResult.add(ARMSTRONG_NUMBERS_LONG_LIMIT[i]);
            }else{
                break;
            }
        }
        long[] result = new long[forResult.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = forResult.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
