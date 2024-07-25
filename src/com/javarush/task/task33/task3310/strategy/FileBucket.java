package com.javarush.task.task33.task3310.strategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket(){
        try {
            path = Files.createTempFile(Integer.toHexString(hashCode()), ".tmp");
            path.toFile().deleteOnExit();
            Files.deleteIfExists(path);
            Files.createFile(path);
        }catch (IOException e){}
    }
    public long getFileSize(){
        if(path == null) return 0;
        try {
            return Files.size(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void putEntry(Entry entry){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(path));
            outputStream.writeObject(entry);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Entry getEntry(){
        if(getFileSize() == 0) return null;
        try {
            return (Entry) new ObjectInputStream(Files.newInputStream(path)).readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
