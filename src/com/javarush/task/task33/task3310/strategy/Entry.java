package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.Objects;

public class Entry implements Serializable {
    /**
     Додайте в Entry наступні поля: Long key, String value, Entry next, int hash.
     Як бачиш, наша реалізація буде підтримувати лише тип Long для ключа та лише  String для значення.
     Область видимості полів залиш за замовчуванням.
     Додай та реалізуй конструкторEntry (int hash , Long key , String value , Entry next ).
     Додай та реалізуй методи:Long getKey(),String getValue(),int hashCode(),boolean equals() String toString().
     Реалізовувати решту методів оригінального Entry не потрібно, ми пишемо спрощену версію.
     **/
    Long key;
    String value;
    Entry next;
    int hash;

    public Entry( int hash, Long key, String value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.hash = hash;
    }

    public Long getKey(){
        return key;
    }
    public String getValue(){
        return value;
    }
    public int hashCode(){
        return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
    }
    public boolean equals(Object entry){
       if(this == entry) {
           return true;
       }
       if(entry instanceof Entry){
           Entry res = (Entry) entry;
           return res.getKey().equals(key) && value.equals(res.getValue());
       }
       return false;
    }
    @Override
    public String toString(){
        return key + "=" + value;
    }
}
