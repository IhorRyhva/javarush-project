package laboratory;

import java.util.Scanner;

public class Seventh {
    public static void main(String[] args) {
        //12.Вилучити всі букви а та о.
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char[] chars = string.toCharArray();
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] != 'a' && chars[i] != 'o' && chars[i] != 'A' && chars[i] != 'O'){
                result += chars[i];
            }
        }
        System.out.println(result);
    }
}
