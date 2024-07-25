package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen implements Country{
    @Override
    public int getCountOfEggsPerMonth() {
        return 50000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + MOLDOVA + ". Я несу " + new MoldovanHen().getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
