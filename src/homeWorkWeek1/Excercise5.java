package homeWorkWeek1;

import java.util.Arrays;
import java.util.Random;

public class Excercise5 {
    public static void main(String[] args) {
        int[][] array = new int[5][8];
        int max = Integer.MIN_VALUE;
        Random random = new Random();
        for (int i = 0; i < 5 ; i++){
            for (int j = 0; j < 8 ; j++){
                array[i][j] = random.nextInt(198)-99;
                if (array[i][j]>max) max = array[i][j];
            }
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.printf("Максимальный элемент массива: %d\n", max);
    }
}
