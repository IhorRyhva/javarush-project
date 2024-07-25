package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        boolean tf = true;
        if(partOfName != null){
            if(!file.toString().contains(partOfName)){
               tf = false;
            }
        }

        if(partOfContent != null){
            List<String> result = Files.readAllLines(file);
            String forResult = "";
            for(String str: result){
                forResult += str;
            }
            if(!forResult.contains(partOfContent)) {
                tf = false;
            }
        }

        if(maxSize > 0){
            if(content.length > maxSize){
                tf = false;
                System.out.println("So big");
            }
        }
        if(minSize >= 0){
            if(content.length < minSize){
                tf = false;
                System.out.println("So small");
            }
        }

        if(tf){
            foundFiles.add(file);
        }
        return super.visitFile(file, attrs);
    }
}
