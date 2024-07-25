package com.javarush.task.pro.task10.task1008;

/* 
Зарплата
*/

public class Programmer {
    private int salary = 1000;

    public int getSalary(){
        return salary;
    }

    public void setSalary(int newSalary){
        this.salary = salary > newSalary? salary: newSalary;
    }

}
