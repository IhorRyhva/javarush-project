package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution.testStrategy(new HashMapStorageStrategy(), 10000);
        System.out.println("_________________");
        Solution.testStrategy(new FileStorageStrategy(), 100);
        System.out.println("_________________");
        Solution.testStrategy(new HashBiMapStorageStrategy(), 10000);
        System.out.println("_________________");
        Solution.testStrategy(new OurHashMapStorageStrategy(), 10000);
        System.out.println("_________________");
        Solution.testStrategy(new OurHashBiMapStorageStrategy(), 10000);
        System.out.println("_________________");
        Solution.testStrategy(new DualHashBidiMapStorageStrategy(), 1000000);
    }
    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> set = new HashSet<>();
        for(String string: strings){
            set.add(shortener.getId(string));
        }
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> set = new HashSet<>();
        for(Long key: keys){
            set.add(shortener.getString(key));
        }
        return set;
    }
    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        System.out.println(strategy.getClass().getSimpleName());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            String s = Helper.generateRandomString();
            strategy.put((long) i, s);
            set.add(s);
        }
        Shortener shortener = new Shortener(strategy);
        Date date1 = new Date();
        Set<Long> keys = Solution.getIds(shortener, set);
        Date date2 = new Date();
        System.out.println(date2.getTime() - date1.getTime());

        Date dateS1 = new Date();
        Set<String> values = Solution.getStrings(shortener, keys);
        Date dateS2 = new Date();
        System.out.println(dateS2.getTime() - dateS1.getTime());

        if(set.containsAll(values)){
            System.out.println("Тест пройден.");
        }else{
            System.out.println("Тест не пройден.");
        }
    }
}
