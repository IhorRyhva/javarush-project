package com.javarush.task.task31.task3104;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/* 
Поиск скрытых файлов
*/

public class Solution extends SimpleFileVisitor<Path> {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        Files.walkFileTree(Paths.get("C:\\Users\\Admin\\javarush\\3349704\\javarush-project\\src\\com\\javarush\\task"), solution);
        List<String> result = solution.getArchived();
        System.out.println("All archived files:");
        for (String path : result) {
            System.out.println("\t" + path);
        }

        List<String> failed = solution.getFailed();
        System.out.println("All failed files:");
        for (String path : failed) {
            System.out.println("\t" + path);
        }
    }

    private List<String> archived = new ArrayList<>();
    private List<String> failed = new ArrayList<>();

    public List<String> getArchived() {
        return archived;
    }

    public List<String> getFailed() {
        return failed;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attr){
        if(path.toString().endsWith("rar") || path.toString().endsWith("zip")) {
            archived.add(path.toString());
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path path, IOException e){
        failed.add(path.toString());
        return FileVisitResult.SKIP_SUBTREE;
    }
}
