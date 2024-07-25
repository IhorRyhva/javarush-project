package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if(desiredColor == null || x > image[0].length - 1 || y > image.length - 1|| desiredColor == image[y][x])
            return false;
        else {
            Color now = image[y][x];
            res(image, x, y, desiredColor, now);
            return true;
        }
    }

    private void res(Color[][] image, int x, int y, Color desiredColor, Color now){
        try{
            if(image[y][x] == now){
                image[y][x] = desiredColor;
                res(image, x + 1, y, desiredColor, now);
                res(image, x - 1, y, desiredColor, now);
                res(image, x, y + 1, desiredColor, now);
                res(image, x, y - 1, desiredColor, now);
            }
        }catch (IndexOutOfBoundsException e){
            return;
        }
    }
}
