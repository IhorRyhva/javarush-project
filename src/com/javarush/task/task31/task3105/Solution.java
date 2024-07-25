package com.javarush.task.task31.task3105;

/*
Добавление файла в архив
*/

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Solution {
    public static void main(String[] args) throws IOException {

        List<Content> entries = getContents(args[1]);

        FileOutputStream zipFile = new FileOutputStream(args[1]);
        ZipOutputStream zip = new ZipOutputStream(zipFile);

        //кладем в него  ZipEntry –«архивный объект»
        File file = new File(args[0]);
        zip.putNextEntry(new ZipEntry("new/" + file.getName()));

        //копируем файл «document-for-archive.txt» в архив под именем «document.txt»
        Files.copy(file.toPath(), zip);

        //копируем все остальные файлы
        for (Content content : entries) {
            if (!content.getFileName().equals("new/" + file.getName())) content.saveToZip(zip);
        }

        // закрываем архив
        zip.close();
    }

    private static List<Content> getContents(String arg) throws IOException {
        List<Content> entries = new ArrayList<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(arg))) {
            ZipEntry currentEntry;
            byte[] buffer = new byte[1024];
            while ((currentEntry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                int length = 0;
                while ((length = zipInputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
                entries.add(new Content(currentEntry.getName(), outputStream.toByteArray()));
            }
        }
        return entries;
    }

    static class Content {
        String fileName;
        byte[] body;

        Content(String fileName, byte[] body) {
            this.fileName = fileName;
            this.body = body;
        }

        public String getFileName() {
            return fileName;
        }

        void saveToZip(ZipOutputStream zip) throws IOException {
            ZipEntry zipEntry = new ZipEntry(fileName);
            zip.putNextEntry(zipEntry);
            zip.write(body);
            zip.closeEntry();
        }
    }
}
//package com.javarush.task.task31.task3105;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.file.*;
//import java.nio.file.attribute.BasicFileAttributes;
//import java.util.ArrayList;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipOutputStream;
//
///*
//Добавление файла в архив
//*/
//
//public class Solution {
//    private static ArrayList<Path> path = new ArrayList<>();
//    public static void main(String[] args) throws IOException {
//        Path zipContainer = Paths.get("C:\\Users\\Admin\\javarush\\3349704\\javarush-project\\src\\com\\javarush\\task\\task31\\task3105\\zip");
//        Path zipFilename = Paths.get("C:\\Users\\Admin\\javarush\\3349704\\javarush-project\\src\\com\\javarush\\task\\task31\\task3105\\forZip");
//        path.add(zipFilename);
//
//        Path forZip = Files.createDirectories(Paths.get("C:\\Users\\Admin\\javarush\\3349704\\javarush-project\\src\\com\\javarush\\task\\task31\\task3105\\new"));
//        ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(forZip.toFile()));
//
//        Walker walker = new Walker();
//        Files.walkFileTree(zipContainer, walker);
//
//        for (Path path1 : path) {
//            ZipEntry zipEntry = new ZipEntry(forZip.relativize(path1).toString());
//            outputStream.putNextEntry(zipEntry);
//            FileInputStream inputStream = new FileInputStream(path1.toFile());
//            outputStream.write(inputStream.readAllBytes());
//            outputStream.closeEntry();
//        }
//    }
//
//    public static void plus(Path entry){
//        path.add(entry);
//    }
//
//    public static class Walker extends SimpleFileVisitor<Path>{
//        @Override
//        public FileVisitResult visitFile(Path path, BasicFileAttributes attr){
//            plus(path);
//            return FileVisitResult.CONTINUE;
//        }
//    }
//}
