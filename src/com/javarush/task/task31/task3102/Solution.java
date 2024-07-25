package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/

public class Solution {
    private static List<String> result = new ArrayList<>();
    public static List<String> getFileTree(String root) throws IOException {
        Files.walkFileTree(Paths.get(root), new Walker());
        return result;
    }

    public static void main(String[] args) throws IOException {
        List<String> stringArrayList = getFileTree("C:\\Users\\Admin\\javarush\\3349704\\javarush-project\\src\\com\\javarush\\task");
        stringArrayList.forEach(System.out::println);
    }

    static class Walker extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attr){
            if(path.isAbsolute()){
                File file = path.toFile();
                result.add(file.getAbsolutePath());
            }

            return FileVisitResult.CONTINUE;
        }
    }
}
