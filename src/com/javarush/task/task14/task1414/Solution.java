package com.javarush.task.task14.task1414;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
MovieFactory
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            String string = bufferedReader.readLine();
            Movie movie;
            while (string.equals("cartoon") || string.equals("soapOpera") || string.equals("thriller")){
                movie = MovieFactory.getMovie(string);
                System.out.println(movie.getClass().getSimpleName());
                string = bufferedReader.readLine();

                if(!string.equals("cartoon") && !string.equals("soapOpera") && !string.equals("thriller")){
                    movie = MovieFactory.getMovie(string);
                }
            }

        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }else if(key.equals("cartoon")){
                movie = new Cartoon();
            }else if("thriller".equals(key)){
                movie = new Thriller();
            }

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie{
    }

    static class Thriller extends Movie{
    }
}
