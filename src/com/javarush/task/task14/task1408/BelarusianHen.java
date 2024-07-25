package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen implements Country{
    @Override
    public int getCountOfEggsPerMonth() {
        return 1000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + BELARUS + ". Я несу " + new BelarusianHen().getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
