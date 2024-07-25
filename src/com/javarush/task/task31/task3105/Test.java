package com.javarush.task.task31.task3105;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Test {
    public static void main(String[] args) throws IOException {
        Path directory = Path.of("C:\\Start\\new");
        Path file = Path.of("C:\\Users\\Admin\\javarush\\3349704\\javarush-project\\src\\com\\javarush\\task\\task31\\task3105\\forZip");
        ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream("C:\\Start\\lalaalala.zip"));
        zip(directory, outputStream);
        zip(file, outputStream);
        outputStream.close();
    }

    public static void zip(Path dir, ZipOutputStream outputStream) throws IOException {
        if(Files.isDirectory(dir)){
            File[] files = dir.toFile().listFiles();
            ZipEntry zipEntry;
            for(File file: files){
                String path = file.getName();
                zipEntry = new ZipEntry(path);
                outputStream.putNextEntry(zipEntry);
                Files.copy(file.toPath(), outputStream);
            }
        }else{
            String path = dir.toFile().getName();
            ZipEntry zipEntry = new ZipEntry(path);
            outputStream.putNextEntry(zipEntry);
            Files.copy(dir, outputStream);
        }
    }
}
