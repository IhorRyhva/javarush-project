package com.javarush.task.task36.task3606;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection C:\Users\Admin\javarush\3349704\javarush-project\src\com\javarush\task\task36\task3606\Solution.java
*/

public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File[] dir = Paths.get("C:\\Users\\Admin\\javarush\\3349704\\javarush-project\\src\\com\\javarush\\task\\task36\\task3606\\data\\second").toFile().listFiles();
        for(File file: dir){
            if(file.getName().endsWith(".java") || file.getName().endsWith(".class")){
                if(file.getName().endsWith(".java")) {
                    hiddenClasses.add(Class.forName("com.javarush.task.task36.task3606.data.second." + file.getName().substring(0, file.getName().length() - 5)));
                }else{
                    hiddenClasses.add(Class.forName("com.javarush.task.task36.task3606.data.second." + file.getName().substring(0, file.getName().length() - 6)));
                }
            }
        }

//        File dir = new File(packageName);
//        ClassLoader classLoader = Solution.class.getClassLoader();
//        for (String fileName : dir.list()) {
//            if (fileName.endsWith(".class")) {
//                String className = packageName.replaceAll("[/\\\\]", ".").substring(packageName.lastIndexOf("ru/")) + "." + fileName.substring(0, fileName.length() - 6);
//                Class<?> aClass = classLoader.loadClass(className);
//                hiddenClasses.add(aClass);
//            }
//        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key){
        key = key.toLowerCase();
        Class<?> cla = null;
        for(Class<?> clazz: hiddenClasses){
            if(clazz.getSimpleName().toLowerCase().startsWith(key)){
                try {
                    cla = clazz;
                    Constructor constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    return (HiddenClass) constructor.newInstance();
                } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                         IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }
}

