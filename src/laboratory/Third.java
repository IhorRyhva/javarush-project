package laboratory;

import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        //1.Написати програму обчислення вартості покупки з врахуванням знижки.
        //Знижка 5% надається якщо вартість покупки перевищує 50 грн.,
        //7% - якщо вартість покупки перевищує 100 грн. При вартості покупки менше 50 грн. знижка не надається

        Scanner scanner = new Scanner(System.in);
        price(scanner.nextDouble());
    }

    private static void price(double a) {
        if(a < 50){
            System.out.println("Price " + a);
        }else if(a >= 50 && a < 100){
            double discount = (a / 100) * 5;
            System.out.println("Price " + (a - discount));
        }else{
            double discount = (a / 100) * 7;
            System.out.println("Price " + (a - discount));
        }
    }
}
