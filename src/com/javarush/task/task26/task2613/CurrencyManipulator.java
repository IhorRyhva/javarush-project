package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {
    private String currencyCode;
    private TreeMap<Integer, Integer> denominations = new TreeMap<>(Comparator.reverseOrder());

    @Override
    public String toString() {
        return "CurrencyManipulator{" +
                "denominations=" + denominations +
                '}';
    }

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
    public void addAmount(int denomination, int count){
        this.denominations.merge(denomination, count, Integer::sum);
    }
    public int getTotalAmount(){
        int res = 0;
        for(Map.Entry<Integer, Integer> map: denominations.entrySet()){
            res += map.getKey() * map.getValue();
        }
        return res;
    }
    public boolean hasMoney(){
        return getTotalAmount() > 0;
    }
    public boolean isAmountAvailable(int cash){
        return getTotalAmount() >= cash;
    }
    public Map<Integer, Integer> withdrawAmount(int cash) throws NotEnoughMoneyException {
//        int sum = cash;
//        HashMap<Integer, Integer> copyDenominations = new HashMap<>(denominations);
//
//        ArrayList<Integer> keys = new ArrayList<>(this.denominations.keySet());
//
//        Collections.sort(keys);
//        Collections.reverse(keys);
//
//        TreeMap<Integer, Integer> resultMap = new TreeMap<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });
//
//        for (Integer denomination : keys) {
//            final int key = denomination;
//            int value = copyDenominations.get(key);
//            while (true) {
//                if (sum < key || value == 0) {
//                    copyDenominations.put(key, value);
//                    break;
//                }
//                sum -= key;
//                value--;
//
//                if (resultMap.containsKey(key))
//                    resultMap.put(key, resultMap.get(key) + 1);
//                else
//                    resultMap.put(key, 1);
//            }
//        }
//
//        if (sum > 0)
//            throw new NotEnoughMoneyException();
//        else {
//            this.denominations.clear();
//            this.denominations.putAll(copyDenominations);
//        }
//        return resultMap;
        int sum = cash;
        Map<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, Integer> tree = new TreeMap<>(denominations);
        for(Map.Entry<Integer, Integer> res: tree.entrySet()){
            int count = res.getValue();
            int denomination = res.getKey();
            while (true) {
                if (denomination > sum || count == 0) {
                    tree.put(denomination, count);
                    break;
                }
                sum -= denomination;
                count--;
                map.merge(denomination, 1, Integer::sum);
            }
        }
        if(sum > 0) {
            System.out.println(denominations);
            throw new ConcurrentModificationException();
        }else {
            denominations.clear();
            denominations.putAll(tree);
        }
        return map;
    }
}
