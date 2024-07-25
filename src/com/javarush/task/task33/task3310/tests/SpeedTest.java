package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Date date1 = new Date();
        for(String string: strings){
            ids.add(shortener.getId(string));
        }
        Date date2 = new Date();
        //System.out.println(date2.getTime() - date1.getTime());
        return date2.getTime() - date1.getTime();
    }
    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date date1 = new Date();
        for(Long id: ids){
            strings.add(shortener.getString(id));
        }
        Date date2 = new Date();
        //System.out.println(date2.getTime() - date1.getTime());
        return date2.getTime() - date1.getTime();
    }
    @Test
    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }
        Set<Long> longs = new HashSet<>();
        long date1 = getTimeToGetIds(shortener1, origStrings, new HashSet<>());
        long date2 = getTimeToGetIds(shortener2, origStrings, longs);
        Assert.assertEquals(date1, date2, 3000);

        long dateS1 = getTimeToGetStrings(shortener1, longs, new HashSet<>());
        origStrings.clear();
        long dateS2 = getTimeToGetStrings(shortener2, longs, origStrings);
        Assert.assertEquals(dateS1, dateS2, 30);
    }
}
