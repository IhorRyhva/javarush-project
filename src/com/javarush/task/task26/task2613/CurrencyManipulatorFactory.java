package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();
    private CurrencyManipulatorFactory(){

    }
    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        for(String key: map.keySet()){
            if(key.equalsIgnoreCase(currencyCode))
                return map.get(key);
        }
        CurrencyManipulator manipulator = new CurrencyManipulator(currencyCode);
        map.put(manipulator.getCurrencyCode(), manipulator);
        return manipulator;
    }
    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return map.values();
    }
}
