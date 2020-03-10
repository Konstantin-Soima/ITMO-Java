package homeWorkWeek1;

import java.util.Scanner;

public class Excercise1 {
    public static void main(String[] args) {
        int num1,num2;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число:");
        num1 = in.nextInt();
        System.out.println("Введите второе число:");
        num2 = in.nextInt();
        while (num1 != 0 && num2 != 0) {
            if (num1 > num2){
                num1 = num1 % num2;
            }
            else
            {
                num2 = num2 % num1;
            }
        }
        System.out.printf("Наибольший общий множитель: %d\n",num1+num2);
    }
}
