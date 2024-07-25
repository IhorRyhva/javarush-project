package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader link = new BufferedReader(new InputStreamReader(System.in));
        String forPath = link.readLine();
        link.close();
        Path cannons = Paths.get(forPath);
        if(Files.isDirectory(cannons)) {
            Visitor visitor = new Visitor();
            Files.walkFileTree(cannons, visitor);
            System.out.println("Всего папок - " + visitor.getCountOfDirs());
            System.out.println("Всего файлов - " + visitor.getCountOfFiles());
            System.out.println("Общий размер - " + visitor.getLength());
        }else{
            System.out.println(forPath + " - не папка");
            return;
        }
    }
}
class Visitor extends SimpleFileVisitor<Path>{
    private int countOfDirs = -1;
    private int countOfFiles = 0;
    private int length = 0;

    public int getCountOfDirs() {
        return countOfDirs;
    }

    public int getCountOfFiles() {
        return countOfFiles;
    }

    public int getLength() {
        return length;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attr) throws IOException {
        if(attr.isRegularFile()){
            countOfFiles++;
            byte[] forLength = Files.readAllBytes(path);
            length += forLength.length;
        }else{
            countOfDirs++;
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attr){
        countOfDirs++;
        return FileVisitResult.CONTINUE;
    }
}
