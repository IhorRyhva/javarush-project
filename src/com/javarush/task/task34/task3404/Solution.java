package com.javarush.task.task34.task3404;

/* 
Рекурсия для мат. выражения
*/

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse("sin(-5+5^2+(2 + 2^2))", 0); // Expected output: 0.5 6
    }

//    public void recurse(final String expression, int countOperation) {
//        countOperation++;
//        String res = arrayList(expression);
//        res = toNormal(res);
//        Stack<Double> number = new Stack<>();
//        Stack<String> move = new Stack<>();
//
//        String[] split = res.split(" ");
//        for (int i = 0; i < split.length; i++) {
//            if (i == split.length - 1) {
//                countOperation++;
//                if(canToDouble(split[i])) {
//                    number.push(Double.parseDouble(split[i]));
//                    while (number.size() > 1) {
//                        number.push(calculate(move.pop(), number));
//                    }
//                }else {
//                    if (!move.empty() && range(move.peek()) >= range(split[i])) {
//                        while (move.size() > 0 && range(split[i]) <= range(move.peek()) && !move.peek().equals("(")) {
//                            countOperation++;
//                            number.push(calculate(move.pop(), number));
//                        }
//                        if (split[i].equals(")")) {
//                            countOperation++;
//                            move.pop();
//                        } else {
//                            move.push(split[i]);
//                        }
//                    } else {
//                        move.push(split[i]);
//                    }
//                    while (number.size() > 1) {
//                        number.push(calculate(move.pop(), number));
//                    }
//                }
//            } else {
//                if (canToDouble(split[i])) {
//                    number.push(Double.parseDouble(split[i]));
//                } else {
//                    if (split[i].equals("(")) {
//                        move.push(split[i]);
//                    } else {
//                        if (!move.empty() && range(move.peek()) >= range(split[i])) {
//                            while (move.size() > 0 && range(split[i]) <= range(move.peek()) && !move.peek().equals("(")) {
//                                countOperation++;
//                                number.push(calculate(move.pop(), number));
//                            }
//                            if (split[i].equals(")")) {
//                                countOperation++;
//                                move.pop();
//                            } else {
//                                move.push(split[i]);
//                            }
//                        } else {
//                            move.push(split[i]);
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(number.peek().toString());
//    }
//
//    private double calculate(String pop, Stack<Double> number) {
//        switch (pop){
//            case "+":
//                return number.pop() + number.pop();
//            case "-":
//                double second = number.pop();
//                double first = number.pop();
//                return first - second;
//            case "*":
//                return number.pop() * number.pop();
//            case "/":
//                double forRes2 = number.pop();
//                double forRes1 = number.pop();
//                return forRes1 / forRes2;
//            case "^":
//                double b = number.pop();
//                double a = number.pop();
//                return Math.pow(a, b);
//            default:
//                return 0;
//        }
//    }
//
//    public int range(String move){
//        if(move.equals("+") || move.equals("-")){
//            return 1;
//        }else if(move.equals("*") || move.equals("/")){
//            return 2;
//        }else if(move.equals(")")){
//            return 0;
//        }else{
//            return 3;
//        }
//    }
//    public boolean canToDouble(String toDouble){
//        try{
//            double res = Double.parseDouble(toDouble);
//            return true;
//        }catch (NumberFormatException e){
//            return false;
//        }
//    }
//    public String toNormal(String string){
//        String[] temp = string.split(" ");
//        ArrayList<String> number = new ArrayList<>();
//        for(String s: temp){
//            if(!s.equals(" ") && !s.equals("")){
//                number.add(s);
//            }
//        }
//        string = "";
//        for (int i = 0; i < number.size(); i++) {
//            if(i < number.size() - 1){
//                string += number.get(i) + " ";
//            }else{
//                string += number.get(i);
//            }
//        }
//        return string;
//    }
//
//    public String arrayList(String s){
//        ArrayList<String> strings = new ArrayList<>();
//        String[] split = s.split("");
//        String string = "";
//        for (int i = 4; i < split.length; i++) {
//            if(((split[i].equals("+") || split[i].equals("^") || split[i].equals("-") || split[i].equals("*") || split[i].equals("/")) && !split[i - 1].equals("(")) && i != 0){
//                strings.add(string);
//                string = "";
//                strings.add(split[i]);
//            }else {
//                if (i == split.length - 2) {
//                    string += split[i];
//                    strings.add(string);
//                } else {
//                    string += split[i];
//                }
//            }
//        }
//        String res = "";
//
//        for(String forRes: strings){
//            if(forRes.contains("(")){
//                String[] array = forRes.split("");
//                array[0] = "( ";
//                forRes = "";
//                for (int i = 0; i < array.length ; i++) {
//                    forRes += array[i];
//                }
//                res += forRes + " ";
//            }else if(forRes.contains(")")){
//                String[] array = forRes.split("");
//                array[array.length - 1] = " )";
//                forRes = "";
//                for (int i = 0; i < array.length ; i++) {
//                    forRes += array[i];
//                }
//                res += forRes + " ";
//            }else{
//                res += " " + forRes + " ";
//            }
//        }
//        return res;
//    }

    private double makeOperation(String s, double first, double second) {
        switch (s) {
            case "+": {
                return first + second;
            }
            case "=": {
                return 0.0 - second;
            }
            case "%": {
                return 0.0 - second;
            }
            case "-": {
                return first - second;
            }
            case "@": {
                return first - second;
            }
            case "*": {
                return first * second;
            }
            case "/": {
                return first / second;
            }
            case "^": {
                return Math.pow(first, second);
            }
            default:
                return -1;
        }
    }

    private double makeFunction(String s, double first) {
        switch (s) {
            case "s": {
                return Math.sin(Math.toRadians(first));
            }
            case "c": {
                return Math.cos(Math.toRadians(first));
            }
            case "t": {
                return Math.tan(Math.toRadians(first));
            }

            default:
                return -1;
        }
    }

    private int getPriority(String s) {
        switch (s) {
            case "+":
            case "-":
            case "=":
            case "%":
            case "@":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            case "c":
            case "s":
            case "t":
                return 4;
            default:
                return -1;
        }
    }

    private boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("@") || c.equals("%") || c.equals("=") || c.equals("*") || c.equals("/") || c.equals("^");
    }

    private boolean isFunction(String c) {
        return c.equals("s") || c.equals("c") || c.equals("t");
    }

    private String doSomething(String expression) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.ENGLISH);
        numberFormat.setRoundingMode(RoundingMode.HALF_EVEN);
        DecimalFormat df = (DecimalFormat) numberFormat;
        df.applyPattern("#.##");
        LinkedList<Double> doubles = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        String workWith = expression.replaceAll("(S|s)(I|i)(N|n)", "s");//Заменяем все функции на одиночный аналог
        workWith = workWith.replaceAll("[Cc][Oo][Ss]", "c");//Заменяем все функции на одиночный аналог
        workWith = workWith.replaceAll("[Tt][Aa][Nn]", "t");//Заменяем все функции на одиночный аналог
        //посчитаем количество операций
        workWith = workWith.replaceAll("^-", "=");
        for (int i = 0; i < 2; i++) {
            Pattern binaryMinus = Pattern.compile("(\\d+\\s?-\\s?\\d+)|([cst]\\s?-\\s?\\d)|(\\d\\s?-\\s?[cst])" +
                    "|([cst]\\s?-\\s?[cst])|(\\)\\s?-\\s?\\()|(\\d+\\s?-\\s?\\()" +
                    "|(\\)\\s?-\\s?\\d+)|([cst]\\s?-\\s?\\()|(\\)\\s?-\\s?[cst])");
            Matcher minusMatcher = binaryMinus.matcher(workWith);
            while (minusMatcher.find()) {
                String group = minusMatcher.group();
                String newString = group.replace('-', '@');
                workWith = workWith.replace(group, newString);
            }
        }
        Pattern strange = Pattern.compile("[^\\d)]\\s?\\-\\s?[\\dcst\\(]");
        Matcher mimi = strange.matcher(workWith);
        while (mimi.find()) {
            String lookfor = mimi.group();
            String replTo = lookfor.replace("-", "%");
            workWith = workWith.replace(lookfor, replTo);
        }
        int numberOfOperations = 0;
        if (numberOfOperations == 0) {
            Pattern operation = Pattern.compile("[sct\\+\\-\\*/\\^=%@]");
            Matcher matcher = operation.matcher(workWith);
            while (matcher.find()) {
                numberOfOperations++;
            }
        }
        //в следующем блоке заменяем все цифры символом D
        Pattern compareWithDecimals = Pattern.compile("-?((\\d*\\.\\d*([eE][\\+\\-]?\\d+)?)|\\d+)");
        Matcher m = compareWithDecimals.matcher(workWith);
        while (m.find()) {
            String ourDouble = m.group();
            doubles.add(Double.parseDouble(ourDouble));
            workWith = workWith.replaceFirst(ourDouble, "D");
        }
        workWith = workWith.replaceAll(" ", "");
        String[] p = workWith.split("");
        LinkedList<String> operators = new LinkedList<>();
        LinkedList<Double> d = new LinkedList<>();
        for (int i = 0; i < p.length; i++) {
            if (p[i].equals("D")) {
                d.add(doubles.removeFirst());
            }
            if (isFunction(p[i]) || isOperator(p[i])) {
                if (operators.size() == 0) {
                    operators.add(p[i]);
                    continue;
                } else {
                    String lastOper = operators.getLast();
                    int lastOperPriority = getPriority(lastOper);
                    int thisPriority = getPriority(p[i]);
                    while (thisPriority <= lastOperPriority && operators.size() > 0) {
                        if (thisPriority == 3 && lastOperPriority == thisPriority) {
                            operators.add(p[i]);
                            break;
                        }
                        Double res = 0.0;
                        String operation = operators.removeLast();
                        if (operation.equals("=") || operation.equals("%")) {
                            Double d2 = d.removeLast();
                            res = makeOperation(operation, 0.0, d2);
                            res = Double.parseDouble(df.format(res));
                            d.add(res);
                            if (operators.size() > 0) {
                                lastOperPriority = getPriority(operators.getLast());
                            } else {
                                lastOperPriority = -1;
                            }
                            continue;
                        }
                        Double d2;
                        Double d1 = 0.0;
                        if (isOperator(operation)) {
                            d2 = d.removeLast();
                            if (d.size() > 0) {
                                d1 = d.removeLast();
                            }
                            res = makeOperation(operation, d1, d2);
                        }
                        if (isFunction(operation)) {
                            d2 = d.removeLast();
                            res = makeFunction(operation, d2);
                        }
                        res = Double.parseDouble(df.format(res));
                        d.add(res);
                        if (operators.size() > 0) {
                            lastOperPriority = getPriority(operators.getLast());
                        } else {
                            lastOperPriority = -1;
                        }
                    }
                }
                operators.add(p[i]);
            }

            if (p[i].equals("(")) {
                operators.add(p[i]);
            }
            if (p[i].equals(")")) {
                String operation = "";
                while (!(operation = operators.removeLast()).equals("(")) {
                    Double res = 0.0;
                    Double d2;
                    if (operation.equals("=") || operation.equals("%")) {
                        d2 = d.removeLast();
                        res = makeOperation(operation, 0.0, d2);
                        res = Double.parseDouble(df.format(res));
                        d.add(res);
                        continue;
                    }
                    Double d1 = 0.0;

                    if (isOperator(operation)) {
                        d2 = d.removeLast();
                        if (d.size() > 0) {
                            d1 = d.removeLast();
                        }
                        res = makeOperation(operation, d1, d2);
                    }
                    if (isFunction(operation)) {
                        d2 = d.removeLast();
                        res = makeFunction(operation, d2);
                    }
                    res = Double.parseDouble(df.format(res));
                    d.add(res);
                }
            }
        }
        String operation = "";
        while (operators.size() != 0) {
            operation = operators.removeLast();
            Double d2;
            Double res = 0.0;
            if (operation.equals("=") || operation.equals("%")) {
                d2 = d.removeLast();
                res = makeOperation(operation, 0.0, d2);
                res = Double.parseDouble(df.format(res));
                d.add(res);
                continue;
            }
            Double d1 = 0.0;
            if (isOperator(operation)) {
                d2 = d.removeLast();
                if (d.size() > 0) {
                    d1 = d.removeLast();
                }
                res = makeOperation(operation, d1, d2);
            }
            if (isFunction(operation)) {
                d2 = d.removeLast();
                res = makeFunction(operation, d2);
            }
            res = Double.parseDouble(df.format(res));
            d.add(res);
        }
        sb = new StringBuilder();
        sb.append(d.get(0));
        for (int i = 0; i < numberOfOperations; i++) {
            sb.append("!");
        }
        sb.append(" ");
        sb.append(numberOfOperations);
        String result = sb.toString();
        return result;
    }

    public void recurse(final String expression, int countOperation) {
        String result = "";
        int count = countOperation;
        Pattern compareWithDecimalss = Pattern.compile("^-?((\\d*\\.\\d*([eE][\\+\\-]?\\d+)?)|\\d+)$");
        Matcher mmm = compareWithDecimalss.matcher(expression);
        if (mmm.matches()) {
            Double d = Double.parseDouble(expression);
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.ENGLISH);
            numberFormat.setRoundingMode(RoundingMode.HALF_EVEN);
            DecimalFormat df = (DecimalFormat) numberFormat;
            df.applyPattern("#.##");
            String stringWeNeed = df.format(d);
            System.out.println(stringWeNeed + " " + countOperation);
            return;
        }
        if (!expression.contains("!")) {
            String strinny = doSomething(expression);
            String[] ss = strinny.split(" ");
            result = ss[0];
            count = Integer.parseInt(ss[1].trim());
        } else {
            result = expression.replaceFirst("!", "");
        }
        recurse(result, count);

    }
    public Solution() {
        //don't delete
    }
}
