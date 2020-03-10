package homeWorkWeek1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Excercise4 {
    public static void main(String[] args) {
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        //бесконечный цикл пока не корректно
        while (n<=3) {
            System.out.print("Введите натуральное число большее 3: ");
            n = scanner.nextInt();
        }
        int[] array = new int[n];
        Random random = new Random();
        int chetCount = 0;
        for  (int i= 0; i < n; i++){
            array[i] = random.nextInt(n);
            if (array[i] % 2 == 0) chetCount++;
        }
        System.out.println("\n"+ Arrays.toString(array));
        if (chetCount>0){
            int[] chets = new int[chetCount];
            int j = 0;
            for  (int i= 0; i < n; i++){
                if (array[i] % 2 == 0) chets[j++]=array[i];
            }
            System.out.println("Чётные числа из массива: \n"+ Arrays.toString(chets));
        }
        else
        {
            System.out.println("чётных элементов нет");
        }
    }

}
