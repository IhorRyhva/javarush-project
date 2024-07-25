package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen implements Country{
    @Override
    public int getCountOfEggsPerMonth() {
        return 100000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + UKRAINE + ". Я несу " + new UkrainianHen().getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
