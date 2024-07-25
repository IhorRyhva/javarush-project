package com.javarush.task.task35.task3505;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <K, V extends Convertable>Map<K, V> convert(List list) {
        Map<K, V> result = new HashMap();
        ArrayList<? extends Convertable> arrayList = (ArrayList<Convertable>) list;
        for(Convertable l: arrayList){
            result.put((K) l.getKey(), (V) l);
        }
        return result;
    }
}
