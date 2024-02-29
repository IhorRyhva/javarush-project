package laboratory;

import java.util.Scanner;

public class Fourth {
    public static void main(String[] args) {
        //5.Написати програму, яка «задумує» число і пропонує користувачу вгадати його за 5 спроб.
        //Після кожної невдалої спроби видається підказка чи задумане число більше або менше від введеного користувачем.
        Scanner scanner = new Scanner(System.in);
        int random = (int)(Math.random()*100);
        for (int i = 0; i < 5; i++) {
            int find = scanner.nextInt();
            if (i == 0) {
                if (find == random) {
                    System.out.println("You win!!");
                    break;
                } else {
                    System.out.println("this number between " + (random - 10) + "  and " + (random + 10));
                }
            } else if (i == 1) {
                if (find == random) {
                    System.out.println("You win!!");
                    break;
                } else {
                    System.out.println("this number between " + (random - 8) + "  and " + (random + 8));
                }

            } else if (i == 2) {
                if (find == random) {
                    System.out.println("You win!!");
                    break;
                } else {
                    System.out.println("this number between " + (random - 5) + "  and " + (random + 5));
                }

            }else if (i == 3) {
                if (find == random) {
                    System.out.println("You win!!");
                    break;
                } else {
                    System.out.println("this number between " + (random - 2) + "  and " + (random + 2));
                }

            }else{
                if (find == random) {
                    System.out.println("You win!!");
                    break;
                } else {
                    System.out.println("this number between " + (random - 1) + "  and " + (random + 1));
                    System.out.print("Last try: ");
                    find = scanner.nextInt();
                    if(find == random){
                        System.out.println("YOU WIN!!!!");
                    }else{
                        System.out.println("You will win next time");
                    }
                }

            }
        }
    }
}
