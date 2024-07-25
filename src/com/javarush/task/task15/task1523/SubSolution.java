package com.javarush.task.task15.task1523;

public class SubSolution extends Solution{
    public SubSolution() {
        super();
        System.out.println("SubSolution");
    }

    protected SubSolution(int a) {
        super(5);
        System.out.println("SubSolution " + a);
    }

    SubSolution(int a, int b){
        super(78);
        System.out.println("SubSolution " + a +", " + b);
    }
}
