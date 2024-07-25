package com.javarush.task.task39.task3913;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        LogParser logParser = new LogParser(Paths.get("C:\\Users\\Admin\\javarush\\3349704\\javarush-project\\src\\com\\javarush\\task\\task39\\task3913\\logs"));
//        logParser.getAllUsers().stream().forEach(System.out::println);
//        System.out.println(logParser.getAllSolvedTasksAndTheirNumber(null, null));
//        Set<Object> set = logParser.execute("get user");
//        System.out.println(set);
        String string = "get ip for user = \"Eduard Petrovich Morozko\" and date between\"11.12.2013 0:00:01\" and \"03.01.2014 23:59:59\"";
        Set<Object> set = logParser.execute(string);
        System.out.println(set);
    }
}