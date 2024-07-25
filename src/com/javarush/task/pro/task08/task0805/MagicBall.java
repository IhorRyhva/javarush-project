package com.javarush.task.pro.task08.task0805;

import java.util.Random;

public class MagicBall {
    private static final String CERTAIN = "Бесспорно";
    private static final String DEFINITELY = "Определённо да";
    private static final String MOST_LIKELY = "Вероятнее всего";
    private static final String OUTLOOK_GOOD = "Хорошие перспективы";
    private static final String ASK_AGAIN_LATER = "Спроси позже";
    private static final String TRY_AGAIN = "Попробуй снова";
    private static final String NO = "Мой ответ — нет";
    private static final String VERY_DOUBTFUL = "Весьма сомнительно";

    public static String getPrediction() {
        String result = "";
        Random number = new Random();
        int randomNumber = number.nextInt(8);
        if(randomNumber == 0){
            result = CERTAIN;
        }
        else if(randomNumber == 1){
            result = DEFINITELY;
        }
        else if(randomNumber == 2){
            result = MOST_LIKELY;
        }
        else if(randomNumber == 3){
            result = OUTLOOK_GOOD;
        }
        else if(randomNumber == 4){
            result = ASK_AGAIN_LATER;
        }
        else if(randomNumber == 5){
            result = TRY_AGAIN;
        }
        else if(randomNumber == 6){
            result = NO;
        }
        else if(randomNumber == 7){
            result = VERY_DOUBTFUL;
        }
        else{
            result = null;
        }

        return result;
    }
}
