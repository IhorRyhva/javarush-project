package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

public class MinMaxUtil {

    public static int min(int min, int min2){
        int realMin = min;
        if(min > min2)
            realMin = min2;
        return realMin;
    }

    public static int min(int min, int min2, int min3){
        int realMin = min;
        if(realMin > min2)
            realMin = min2;
        if(realMin > min3)
            realMin = min3;
        return realMin;
    }

    public static int min(int min, int min2, int min3, int min4){
        int realMin = min;
        if(realMin > min2)
            realMin = min2;
        if(realMin > min3)
            realMin = min3;
        if(realMin > min4)
            realMin = min4;
        return realMin;
    }

    public static int min(int min, int min2, int min3, int min4, int min5){
        int realMin = min;
        if(realMin > min2)
            realMin = min2;
        if(realMin > min3)
            realMin = min3;
        if(realMin > min4)
            realMin = min4;
        if(realMin > min5)
            realMin = min5;
        return realMin;
    }

    public static int max(int max, int max1){
        int realMax = max;
        if(realMax < max1){
            realMax = max1;
        }
        return realMax;
    }

    public static int max(int max, int max1, int max2){
        int realMax = max;
        if(max1 > realMax)
            realMax = max1;
        if(max2 > realMax)
            realMax = max2;
        return realMax;
    }

    public static int max(int max, int max1, int max2, int max3){
        int realMax = max;
        if(max1 > realMax)
            realMax = max1;
        if(max2 > realMax)
            realMax = max2;
        if(max3 > realMax)
            realMax = max3;
        return realMax;
    }

    public static int max(int max, int max1, int max2, int max3, int max4){
        int realMax = max;
        if(max1 > realMax)
            realMax = max1;
        if(max2 > realMax)
            realMax = max2;
        if(max3 > realMax)
            realMax = max3;
        if(max4 > realMax)
            realMax = max4;
        return realMax;
    }
}
