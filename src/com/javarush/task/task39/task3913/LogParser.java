package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.*;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;
    private File[] dir;
    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    private DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd.M.yyyy H:m:s");
    public LogParser(Path logDir) {
        this.logDir = logDir;
        start();
    }
    private void start(){
        dir = logDir.toFile().listFiles();
    }
    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> strings = new HashSet<>();
        int res;
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            if(after != null && before != null) {
                for (File file : dir) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()){
                        String[] array = reader.readLine().split("\t");
                        Date date = formatter.parse(array[2]);
                        if((date.after(after) || date.compareTo(after) == 0) && (date.before(before) || date.compareTo(before) == 0)){
                            strings.add(array[0]);
                        }
                        reader.close();
                    }
                }
            }else if(after == null && before != null){
                for (File file : dir) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        Date date = formatter.parse(array[2]);
                        if(date.before(before) || date.compareTo(before) == 0){
                            strings.add(array[0]);
                        }
                    }
                    reader.close();
                }
            }else if(after != null && before == null){
                for (File file : dir) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        Date date = formatter.parse(array[2]);
                        if(date.after(after) || date.compareTo(after) == 0){
                            strings.add(array[0]);
                        }
                    }
                    reader.close();
                }
            }else{
                for (File file : dir) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        strings.add(array[0]);
                        //System.out.println(array[0]);
                    }
                    reader.close();
                }
            }
        }catch (FileNotFoundException e){

        } catch (IOException e) {

        }catch (ParseException e){
            System.out.println("parse");
        }
        res = strings.toArray().length;
        return res;
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> strings = new HashSet<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            if(after != null && before != null) {
                for (File file : dir) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()){
                        String[] array = reader.readLine().split("\t");
                        Date date = formatter.parse(array[2]);
                        if((date.after(after) || date.compareTo(after) == 0) && (date.before(before) || date.compareTo(before) == 0)){
                            strings.add(array[0]);
                        }
                    }
                    reader.close();
                }
            }else if(after == null && before != null){
                for (File file : dir) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        Date date = formatter.parse(array[2]);
                        if(date.before(before) || date.compareTo(before) == 0){
                            strings.add(array[0]);
                        }
                    }
                    reader.close();
                }
            }else if(after != null && before == null){
                for (File file : dir) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        Date date = formatter.parse(array[2]);
                        if(date.after(after) || date.compareTo(after) == 0){
                            strings.add(array[0]);
                        }
                    }
                    reader.close();
                }
            }else{
                for (File file : dir) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        strings.add(array[0]);
                    }
                    reader.close();
                }
            }
        }catch (FileNotFoundException e){

        } catch (IOException e) {

        }catch (ParseException e){
            System.out.println("parse");
        }
        return strings;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> strings = new HashSet<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            if(after != null && before != null) {
                for (File file : dir) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()){
                        String[] array = reader.readLine().split("\t");
                        Date date = formatter.parse(array[2]);
                        if((date.after(after) || date.compareTo(after) == 0) && (date.before(before) || date.compareTo(before) == 0)){
                            if(user.equals(array[1])) {
                                strings.add(array[0]);
                            }
                        }
                    }
                    reader.close();
                }
            }else if(after == null && before != null){
                for (File file : dir) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        Date date = formatter.parse(array[2]);
                        if(date.before(before) || date.compareTo(before) == 0){
                            if(user.equals(array[1])) {
                                strings.add(array[0]);
                            }
                        }
                    }
                    reader.close();
                }
            }else if(after != null && before == null){
                for (File file : dir) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        Date date = formatter.parse(array[2]);
                        if(date.after(after) || date.compareTo(after) == 0){
                            if(user.equals(array[1])) {
                                strings.add(array[0]);
                            }
                        }
                    }
                    reader.close();
                }
            }else{
                for (File file : dir) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        if(user.equals(array[1])) {
                            strings.add(array[0]);
                        }
                    }
                    reader.close();
                }
            }
        }catch (FileNotFoundException e){

        } catch (IOException e) {

        }catch (ParseException e){
            System.out.println("parse");
        }
        return strings;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> strings = new HashSet<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            if(after != null && before != null) {
                for (File file : dir) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()){
                        String[] array = reader.readLine().split("\t");
                        Date date = formatter.parse(array[2]);
                        if((date.after(after) || date.compareTo(after) == 0) && (date.before(before) || date.compareTo(before) == 0)){
                            if(array[3].contains(event.toString())) {
                                strings.add(array[0]);
                            }
                        }
                    }
                    reader.close();
                }
            }else if(after == null && before != null){
                for (File file : dir) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        Date date = formatter.parse(array[2]);
                        if(date.before(before) || date.compareTo(before) == 0){
                            if(array[3].contains(event.toString())) {
                                strings.add(array[0]);
                            }
                        }
                    }
                    reader.close();
                }
            }else if(after != null && before == null){
                for (File file : dir) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        Date date = formatter.parse(array[2]);
                        if(date.after(after) || date.compareTo(after) == 0){
                            if(array[3].contains(event.toString())) {
                                strings.add(array[0]);
                            }
                        }
                    }
                    reader.close();
                }
            }else{
                for (File file : dir) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        if(array[3].contains(event.toString())) {
                            strings.add(array[0]);
                        }
                    }
                    reader.close();
                }
            }
        }catch (FileNotFoundException e){

        } catch (IOException e) {

        }catch (ParseException e){
            System.out.println("parse");
        }
        return strings;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> strings = new HashSet<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            if(after != null && before != null) {
                for (File file : dir) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()){
                        String[] array = reader.readLine().split("\t");
                        Date date = formatter.parse(array[2]);
                        if((date.after(after) || date.compareTo(after) == 0) && (date.before(before) || date.compareTo(before) == 0)){
                            if(array[4].contains(status.toString())) {
                                strings.add(array[0]);
                            }
                        }
                    }
                    reader.close();
                }
            }else if(after == null && before != null){
                for (File file : dir) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        Date date = formatter.parse(array[2]);
                        if(date.before(before) || date.compareTo(before) == 0){
                            if(array[4].contains(status.toString())) {
                                strings.add(array[0]);
                            }
                        }
                    }
                    reader.close();
                }
            }else if(after != null && before == null){
                for (File file : dir) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        Date date = formatter.parse(array[2]);
                        if(date.after(after) || date.compareTo(after) == 0){
                            if(array[4].contains(status.toString())) {
                                strings.add(array[0]);
                            }
                        }
                    }
                    reader.close();
                }
            }else{
                for (File file : dir) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        if(array[4].contains(status.toString())) {
                            strings.add(array[0]);
                        }
                    }
                    reader.close();
                }
            }
        }catch (FileNotFoundException e){

        } catch (IOException e) {

        }catch (ParseException e){
            System.out.println("parse");
        }
        return strings;
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> users = new HashSet<>();
        for(File file: dir){
            if (file.toString().toLowerCase().endsWith(".log")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    while (reader.ready()) {
                        String temp = reader.readLine().split("\t")[1];
                        users.add(temp);
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return users;
    }
    private boolean dateBetweenDates(Date current, Date after, Date before) {
        if (after == null) {
            after = new Date(0);
        }
        if (before == null) {
            before = new Date(Long.MAX_VALUE);
        }
        return current.after(after) && current.before(before);
    }
    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> res = new HashSet<>();
        for(File file: dir){
            if(file.toString().toLowerCase().endsWith(".log")){
                try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                    while (reader.ready()){
                        String[] array = reader.readLine().split("\t");
                        Date date = format.parse(array[2]);
                        if (dateBetweenDates(date, after, before)){
                            res.add(array[0]);
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return res.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<String> res = new HashSet<>();
        for(File file: dir) {
            if (file.toString().toLowerCase().endsWith(".log")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        Date date = format.parse(array[2]);
                        if(dateBetweenDates(date, after, before) && array[1].equals(user)){
                            res.add(array[3]);
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return res.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> res = new HashSet<>();
        for(File file: dir) {
            if (file.toString().toLowerCase().endsWith(".log")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        Date date = format.parse(array[2]);
                        if(dateBetweenDates(date, after, before) && array[0].equals(ip)){
                            res.add(array[1]);
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return res;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> res = new HashSet<>();
        for(File file: dir) {
            if (file.toString().toLowerCase().endsWith(".log")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        Date date = format.parse(array[2]);
                        if(dateBetweenDates(date, after, before)){
                            if(array[3].contains(Event.LOGIN.toString()))
                                res.add(array[1]);
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return res;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {Set<String> res = new HashSet<>();
        for(File file: dir) {
            if (file.toString().toLowerCase().endsWith(".log")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        Date date = format.parse(array[2]);
                        if(dateBetweenDates(date, after, before)){
                            if(array[3].contains(Event.DOWNLOAD_PLUGIN.toString()))
                                res.add(array[1]);
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return res;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {Set<String> res = new HashSet<>();
        for(File file: dir) {
            if (file.toString().toLowerCase().endsWith(".log")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        Date date = format.parse(array[2]);
                        if(dateBetweenDates(date, after, before)){
                            if(array[3].contains(Event.WRITE_MESSAGE.toString()))
                                res.add(array[1]);
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return res;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> res = new HashSet<>();
        for(File file: dir) {
            if (file.toString().toLowerCase().endsWith(".log")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        Date date = format.parse(array[2]);
                        if(dateBetweenDates(date, after, before)){
                            if(array[3].contains(Event.SOLVE_TASK.toString()))
                                res.add(array[1]);
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return res;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> res = new HashSet<>();
        for(File file: dir) {
            if (file.toString().toLowerCase().endsWith(".log")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        Date date = format.parse(array[2]);
                        if(dateBetweenDates(date, after, before)){
                            String[] forUse = array[3].split(" ");
                            if(dateBetweenDates(date, after, before) && forUse.length == 2 && array[3].contains(Event.SOLVE_TASK.toString())){
                                int number = Integer.parseInt(forUse[1]);
                                if(task == number)
                                    res.add(array[1]);
                            }
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return res;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> res = new HashSet<>();
        for(File file: dir) {
            if (file.toString().toLowerCase().endsWith(".log")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        Date date = format.parse(array[2]);
                        if(dateBetweenDates(date, after, before)){
                            if(array[3].contains(Event.DONE_TASK.toString()))
                                res.add(array[1]);
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return res;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> res = new HashSet<>();
        for(File file: dir) {
            if (file.toString().toLowerCase().endsWith(".log")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    while (reader.ready()) {
                        String[] array = reader.readLine().split("\t");
                        Date date = format.parse(array[2]);
                        String[] forUse = array[3].split(" ");
                        if(dateBetweenDates(date, after, before) && forUse.length == 2 && array[3].contains(Event.DONE_TASK.toString())){
                            int number = Integer.parseInt(forUse[1]);
                            if(task == number)
                                res.add(array[1]);
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return res;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> result = new HashSet<>();
        for(File file: dir){
            if(file.toString().toLowerCase().endsWith(".log")){
                try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                    while(reader.ready()){
                        String[] array = reader.readLine().split("\t");
                        Date date = format.parse(array[2]);
                        if(dateBetweenDates(date, after, before) && array[3].contains(event.toString()) && array[1].equals(user)){
                            result.add(date);
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> result = new HashSet<>();
        for(File file: dir){
            if(file.toString().toLowerCase().endsWith(".log")){
                try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                    while (reader.ready()){
                        String[] array = reader.readLine().split("\t");
                        Date date = format.parse(array[2]);
                        if(dateBetweenDates(date, after, before) && array[4].contains(Status.FAILED.toString())){
                            result.add(date);
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> result = new HashSet<>();
        for(File file: dir){
            if(file.toString().toLowerCase().endsWith(".log")){
                try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                    while (reader.ready()){
                        String[] array = reader.readLine().split("\t");
                        Date date = format.parse(array[2]);
                        if(dateBetweenDates(date, after, before) && array[4].contains(Status.ERROR.toString())){
                            result.add(date);
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        TreeSet<Date> tree = new TreeSet<>();
        Date date = null;
        for(File file: dir){
            if(file.toString().toLowerCase().endsWith(".log")){
                try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                    while (reader.ready()){
                        String[] array = reader.readLine().split("\t");
                        if(array[1].equals(user)){
                            Date temp = format.parse(array[2]);
                            if(dateBetweenDates(temp, after, before)){
                                if(array[3].contains(Event.LOGIN.toString())){
                                    tree.add(temp);
                                }
                            }
                        }
                    }

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if(tree.size() > 0)
            date = tree.first();
        return date;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Date date = null;
        TreeSet<Date> tree = new TreeSet<>();

        for(File file: dir){
            if(file.toString().toLowerCase().endsWith(".log")){
                try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                    while (reader.ready()){
                        String[] array = reader.readLine().split("\t");
                        if(array[1].equals(user)){
                            Date temp = format.parse(array[2]);
                            String[] tempArray = array[3].split(" ");
                            if(dateBetweenDates(temp, after, before)){
                                if(tempArray.length == 2 && array[3].contains(Event.SOLVE_TASK.toString())){
                                    int forTask = Integer.parseInt(tempArray[1]);
                                    if(task == forTask)
                                        tree.add(temp);
                                }
                            }
                        }
                    }

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if(tree.size() > 0)
            date = tree.first();
        return date;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Date date = null;
        TreeSet<Date> tree = new TreeSet<>();

        for(File file: dir){
            if(file.toString().toLowerCase().endsWith(".log")){
                try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                    while (reader.ready()){
                        String[] array = reader.readLine().split("\t");
                        if(array[1].equals(user)){
                            Date temp = format.parse(array[2]);
                            String[] tempArray = array[3].split(" ");
                            if(dateBetweenDates(temp, after, before)){
                                if(tempArray.length == 2 && array[3].contains(Event.DONE_TASK.toString())){
                                    int forTask = Integer.parseInt(tempArray[1]);
                                    if(task == forTask)
                                        tree.add(temp);
                                }
                            }
                        }
                    }

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if(tree.size() > 0)
            date = tree.first();
        return date;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        TreeSet<Date> tree = new TreeSet<>();

        for(File file: dir){
            if(file.toString().toLowerCase().endsWith(".log")){
                try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                    while (reader.ready()){
                        String[] array = reader.readLine().split("\t");
                        if(array[1].equals(user)){
                            Date temp = format.parse(array[2]);
                            if(dateBetweenDates(temp, after, before)){
                                if(array[3].contains(Event.WRITE_MESSAGE.toString())){
                                    tree.add(temp);
                                }
                            }
                        }
                    }

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return tree;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        TreeSet<Date> tree = new TreeSet<>();

        for(File file: dir){
            if(file.toString().toLowerCase().endsWith(".log")){
                try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                    while (reader.ready()){
                        String[] array = reader.readLine().split("\t");
                        if(array[1].equals(user)){
                            Date temp = format.parse(array[2]);
                            if(dateBetweenDates(temp, after, before)){
                                if(array[3].contains(Event.DOWNLOAD_PLUGIN.toString())){
                                    tree.add(temp);
                                }
                            }
                        }
                    }

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return tree;
    }

    private Event event(String string){
        Event event = null;
        if (string.contains(Event.LOGIN.toString())) {
            event = (Event.LOGIN);
        } else if (string.contains(Event.DOWNLOAD_PLUGIN.toString())) {
            event = (Event.DOWNLOAD_PLUGIN);
        } else if (string.contains(Event.WRITE_MESSAGE.toString())) {
            event = (Event.WRITE_MESSAGE);
        } else if (string.contains(Event.SOLVE_TASK.toString())) {
            event = (Event.SOLVE_TASK);
        } else if (string.contains(Event.DONE_TASK.toString())) {
            event = (Event.DONE_TASK);
        }
        return event;
    }
    private Status status(String string){
        Status status = null;
        if(string.equals(Status.OK.toString())){
            status = (Status.OK);
        }else if(string.equals(Status.FAILED.toString())){
            status =(Status.FAILED);
        }else if(string.equals(Status.ERROR.toString())){
            status =(Status.ERROR);
        }
        return status;
    }
    @Override
    public Set<Object> execute(String query) {
        String[] forField2 = query.split(" = ");
        StringBuilder field2 = new StringBuilder();
        String[] consistDate = new String[3];
        boolean tf = true;
        if(forField2.length == 2 && query.contains(" and date between")){
            consistDate = forField2[1].split(" and ");
            if(consistDate[0] != null && consistDate[1] != null && consistDate[2] != null) {
                consistDate[0] = consistDate[0].substring(1, consistDate[0].length() - 1);
                consistDate[1] = consistDate[1].substring(consistDate[1].lastIndexOf('n') + 2, consistDate[1].length() - 1);
                consistDate[2] = consistDate[2].substring(1, consistDate[2].length() - 1);
            }else{
                tf = false;
            }
        }

        Set<Object> tree = new TreeSet<>();
        ArrayList<Log> logs = bufferedReader(dir);
        if(!query.contains(" and date between")) {
            if (forField2.length == 1) {
                if (query.equals("get ip")) {
                    for (Log log : logs) {
                        tree.add(log.getIp());
                    }
                } else if (query.equals("get user")) {
                    for (Log log : logs) {
                        tree.add(log.getName());
                    }
                } else if (query.equals("get date")) {
                    for (Log log : logs) {
                        tree.add(log.getDate());
                    }
                } else if (query.equals("get event")) {
                    for (Log log : logs) {
                        if (log.getEvent().contains(Event.LOGIN.toString())) {
                            tree.add(Event.LOGIN);
                        } else if (log.getEvent().contains(Event.DOWNLOAD_PLUGIN.toString())) {
                            tree.add(Event.DOWNLOAD_PLUGIN);
                        } else if (log.getEvent().contains(Event.WRITE_MESSAGE.toString())) {
                            tree.add(Event.WRITE_MESSAGE);
                        } else if (log.getEvent().contains(Event.SOLVE_TASK.toString())) {
                            tree.add(Event.SOLVE_TASK);
                        } else if (log.getEvent().contains(Event.DONE_TASK.toString())) {
                            tree.add(Event.DONE_TASK);
                        }
                    }
                } else if (query.equals("get status")) {
                    for (Log log : logs) {
                        if (log.getStatus().equals(Status.OK.toString())) {
                            tree.add(Status.OK);
                        } else if (log.getStatus().equals(Status.FAILED.toString())) {
                            tree.add(Status.FAILED);
                        } else if (log.getStatus().equals(Status.ERROR.toString())) {
                            tree.add(Status.ERROR);
                        }
                    }
                    /**getIp**/
                }
            } else if (forField2.length == 2) {
                field2 = new StringBuilder(forField2[1]);
                field2.delete(0, 1);
                field2.delete(field2.length() - 1, field2.length());
                if (query.contains("get ip for user =")) {
                    String[] array = query.split(" = ");
                    StringBuilder forDate = new StringBuilder(array[1]);
                    forDate.delete(0, 1);
                    forDate.delete(forDate.length() - 1, forDate.length());
                    //System.out.println(forDate.toString());
                    for (Log log : logs) {
                        if (forDate.toString().equals(log.getName())) {
                            tree.add(log.getIp());
                        }
                    }
                } else if (query.contains("get ip for date =")) {
                    try {
                        String[] array = query.split(" = ");
                        StringBuilder forDate = new StringBuilder(array[1]);
                        forDate.delete(0, 1);
                        forDate.delete(forDate.length() - 1, forDate.length());
                        Date date = format.parse(forDate.toString());
                        for (Log log : logs) {
                            if (log.getDate().compareTo(date) == 0)
                                tree.add(log.getIp());
                        }
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                } else if (query.contains("get ip for event =")) {
                    String[] array = query.split(" = ");
                    StringBuilder ip = new StringBuilder(array[1]);
                    ip.delete(0, 1);
                    ip.delete(ip.length() - 1, ip.length());
                    for (Log log : logs) {
                        if (log.getEvent().contains(ip.toString()))
                            tree.add(log.getIp());
                    }
                } else if (query.contains("get ip for status =")) {
                    String[] array = query.split(" = ");
                    StringBuilder ip = new StringBuilder(array[1]);
                    ip.delete(0, 1);
                    ip.delete(ip.length() - 1, ip.length());
                    for (Log log : logs) {
                        if (log.getStatus().equals(ip.toString()))
                            tree.add(log.getIp());
                    }
                }/**get user**/
                else if (query.contains("get user for ip =")) {
                    String[] array = query.split(" = ");
                    StringBuilder ip = new StringBuilder(array[1]);
                    ip.delete(0, 1);
                    ip.delete(ip.length() - 1, ip.length());
                    for (Log log : logs) {
                        if (log.getIp().equals(ip.toString())) {
                            tree.add(log.getName());
                        }
                    }
                } else if (query.contains("get user for date =")) {
                    try {
                        String[] array = query.split(" = ");
                        StringBuilder ip = new StringBuilder(array[1]);
                        ip.delete(0, 1);
                        ip.delete(ip.length() - 1, ip.length());
                        Date date = format.parse(ip.toString());
                        for (Log log : logs) {
                            if (log.getDate().compareTo(date) == 0) {
                                tree.add(log.getName());
                            }
                        }
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                } else if (query.contains("get user for event =")) {
                    String event = field2.toString();
                    for (Log log : logs) {
                        if (log.getEvent().contains(event))
                            tree.add(log.getName());
                    }
                } else if (query.contains("get user for status =")) {
                    String status = field2.toString();
                    for (Log log : logs) {
                        if (log.getStatus().equals(status))
                            tree.add(log.getName());
                    }
                }/**get date**/
                else if (query.contains("get date for ip =")) {
                    String forDate = field2.toString();
                    for (Log log : logs) {
                        if (forDate.equals(log.getIp())) {
                            tree.add(log.getDate());
                        }
                    }
                } else if (query.contains("get date for user =")) {
                    String forDate = field2.toString();
                    for (Log log : logs) {
                        if (forDate.equals(log.getName())) {
                            tree.add(log.getDate());
                        }
                    }
                } else if (query.contains("get date for event =")) {
                    String forDate = field2.toString();
                    for (Log log : logs) {
                        if (log.getEvent().contains(forDate.toString())) {
                            tree.add(log.getDate());
                        }
                    }
                } else if (query.contains("get date for status =")) {
                    String forDate = field2.toString();
                    for (Log log : logs) {
                        if (forDate.equals(log.getStatus())) {
                            tree.add(log.getDate());
                        }
                    }
                }/**get event**/
                else if (query.contains("get event for ip =")) {
                    String forEvent = field2.toString();
                    for (Log log : logs) {
                        if (forEvent.equals(log.getIp())) {
                            tree.add(event(log.getEvent()));
                        }
                    }
                } else if (query.contains("get event for user =")) {
                    String forEvent = field2.toString();
                    for (Log log : logs) {
                        if (forEvent.equals(log.getName())) {
                            tree.add(event(log.getEvent()));
                        }
                    }
                } else if (query.contains("get event for date =")) {
                    try {
                        String forEvent = field2.toString();
                        Date date = format.parse(forEvent);
                        for (Log log : logs) {
                            if (date.compareTo(log.getDate()) == 0) {
                                tree.add(event(log.getEvent()));
                            }
                        }
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                } else if (query.contains("get event for status =")) {
                    String forEvent = field2.toString();
                    for (Log log : logs) {
                        if (forEvent.equals(log.getStatus())) {
                            tree.add(event(log.getEvent()));
                        }
                    }
                }/**get Status**/
                else if (query.contains("get status for ip =")) {
                    String forStatus = field2.toString();
                    for (Log log : logs) {
                        if (forStatus.equals(log.getIp()))
                            tree.add(status(log.getStatus()));
                    }
                } else if (query.contains("get status for date =")) {
                    try {
                        String forStatus = field2.toString();
                        Date date = format.parse(forStatus.toString());
                        for (Log log : logs) {
                            if (date.compareTo(log.getDate()) == 0) {
                                tree.add(status(log.getStatus()));
                            }
                        }
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                } else if (query.contains("get status for user =")) {
                    String forStatus = field2.toString();
                    for (Log log : logs) {
                        if (forStatus.equals(log.getName()))
                            tree.add(status(log.getStatus()));
                    }
                } else if (query.contains("get status for event =")) {
                    String forStatus = field2.toString();
                    for (Log log : logs) {
                        if (log.getEvent().contains(forStatus.toString()))
                            tree.add(status(log.getStatus()));
                    }
                }
            }
        }else if(query.contains(" and date between") && tf){
            if(query.contains("get ip for user")){
                String first = consistDate[0];
                LocalDateTime after = LocalDateTime.parse(consistDate[1], timeFormat);
                LocalDateTime before = LocalDateTime.parse(consistDate[2], timeFormat);
                for(Log log: logs){
                    if(log.getName().equals(first)){
                        if(log.getDateTime().isAfter(after) && log.getDateTime().isBefore(before)){
                            tree.add(log.getIp());
                        }
                    }
                }
            }else if(query.contains("get ip for date")){
                try {
                    String first = consistDate[0];
                    Date after = format.parse(consistDate[1]);
                    Date before = format.parse(consistDate[2]);
                    Date date1 = format.parse(first);
                    for(Log log: logs){
                        if(log.getDate().compareTo(date1) == 0){
                            if(log.getDate().getTime() > after.getTime() && log.getDate().getTime() < before.getTime()){
                                tree.add(log.getIp());
                            }
                        }
                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return tree;
    }

    private class Log{
        private String ip;
        private String name;
        private Date date;
        private String event;
        private String status;
        private LocalDateTime dateTime;

        public Log(String ip, String name, Date date, String event, String status, String forLocalDate) {
            this.ip = ip;
            this.name = name;
            this.date = date;
            this.event = event;
            this.status = status;
            this.dateTime = LocalDateTime.parse(forLocalDate, timeFormat);
        }

        public LocalDateTime getDateTime() {
            return dateTime;
        }

        public String getIp() {
            return ip;
        }

        public String getName() {
            return name;
        }

        public Date getDate() {
            return date;
        }

        public String getEvent() {
            return event;
        }

        public String getStatus() {
            return status;
        }
    }
    private ArrayList<Log> bufferedReader(File[] files){
        ArrayList<Log> logs = bufferedReader(files);
        return logs;
    }
    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();
        ArrayList<Log> arrayList = bufferedReader(dir);
        for(Log log: arrayList){
            Date date = log.getDate();
            if(dateBetweenDates(date, after, before)){
                extracted(log, events);
            }
        }
        return events.size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();
        ArrayList<Log> arrayList = bufferedReader(dir);
        for(Log log: arrayList){
            Date date = log.getDate();
            if(dateBetweenDates(date, after, before)){
                extracted(log, events);
            }
        }
        return events;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> events = new HashSet<>();
        ArrayList<Log> arrayList = bufferedReader(dir);
        for(Log log: arrayList){
            Date date = log.getDate();
            if(dateBetweenDates(date, after, before) && log.getIp().equals(ip)){
                extracted(log, events);
            }
        }
        return events;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> events = new HashSet<>();
        ArrayList<Log> arrayList = bufferedReader(dir);
        for(Log log: arrayList){
            Date date = log.getDate();
            if(dateBetweenDates(date, after, before) && log.getName().equals(user)){
                extracted(log, events);
            }
        }
        return events;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();
        ArrayList<Log> arrayList = bufferedReader(dir);
        for(Log log: arrayList){
            Date date = log.getDate();
            if(dateBetweenDates(date, after, before) && log.getStatus().contains(Status.FAILED.toString())){
                extracted(log, events);
            }
        }
        return events;
    }

    private static void extracted(Log log, Set<Event> events) {
        if(log.getEvent().contains(Event.LOGIN.toString())) {
            events.add(Event.LOGIN);
        }else if(log.getEvent().contains(Event.DOWNLOAD_PLUGIN.toString())){
            events.add(Event.DOWNLOAD_PLUGIN);
        }else if(log.getEvent().contains(Event.WRITE_MESSAGE.toString())){
            events.add(Event.WRITE_MESSAGE);
        }else if(log.getEvent().contains(Event.SOLVE_TASK.toString())){
            events.add(Event.SOLVE_TASK);
        }else if(log.getEvent().contains(Event.DONE_TASK.toString())){
            events.add(Event.DONE_TASK);
        }
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();
        ArrayList<Log> arrayList = bufferedReader(dir);
        for(Log log: arrayList){
            Date date = log.getDate();
            if(dateBetweenDates(date, after, before) && log.getStatus().contains(Status.ERROR.toString())){
                extracted(log, events);
            }
        }
        return events;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        ArrayList<Log> logs = bufferedReader(dir);
        int count = 0;
        for(Log log: logs){
            String[] array = log.getEvent().split(" ");
            if(array.length == 2){
                if(dateBetweenDates(log.getDate(), after, before) && log.getEvent().contains(Event.SOLVE_TASK.toString())){
                    int forTask = Integer.parseInt(array[1]);
                    if(task == forTask){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        ArrayList<Log> logs = bufferedReader(dir);
        int count = 0;
        for(Log log: logs){
            String[] array = log.getEvent().split(" ");
            if(array.length == 2){
                if(dateBetweenDates(log.getDate(), after, before)){
                    int forTask = Integer.parseInt(array[1]);
                    if(task == forTask &&  log.getEvent().contains(Event.DONE_TASK.toString())){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        //(номер_задачи : количество_попыток_решить_ее).
        Map<Integer, Integer> maps = new TreeMap<>();
        ArrayList<Log> logs = bufferedReader(dir);
        for(Log log: logs){
            String[] array = log.getEvent().split(" ");
            if(log.getEvent().contains(Event.SOLVE_TASK.toString()) && dateBetweenDates(log.getDate(), after, before)) {
                if (array.length == 2) {
                    int key = Integer.parseInt(array[1]);
                    maps.merge(key, 1, Integer::sum);
                }
            }
        }
        return maps;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        //(номер_задачи : сколько_раз_ее_решили)
        Map<Integer, Integer> maps = new TreeMap<>();
        ArrayList<Log> logs = bufferedReader(dir);
        for(Log log: logs){
            String[] array = log.getEvent().split(" ");
            if(array.length == 2 && log.getEvent().contains(Event.DONE_TASK.toString()) && dateBetweenDates(log.getDate(), after, before)){
                int key = Integer.parseInt(array[1]);
                maps.merge(key, 1, Integer::sum);
            }
        }
        return maps;
    }
}
