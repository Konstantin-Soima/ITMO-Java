package homeWorkWeek1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Excercise3 {
    public static void main(String[] args) {
        System.out.print("Введите размер массива: ");
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];
        Random random = new Random();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        long summ = 0;
        for  (int i= 0; i < arraySize; i++){
            array[i] = random.nextInt(200)-100;
            if (array[i]>max) max = array[i];
            if (array[i]<min) min = array[i];
            summ+=array[i];
        }
        float avg = (float)summ/(float)arraySize;
        System.out.println("\n"+Arrays.toString(array));
        System.out.printf("минимальное значение: %d\n", min);
        System.out.printf("максимальное значение: %d\n", max);
        System.out.printf("среднее значение: %.2f\n", avg);
    }

}
