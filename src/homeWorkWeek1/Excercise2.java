package homeWorkWeek1;

import java.util.Arrays;

public class Excercise2 {
    public static void main(String[] args) {
        int[] numbersArray = {1,7,5,3,6,8};
        int sum = 7;
        //отсортеруем по возрастанию пузырьком
        System.out.println(Arrays.toString(numbersArray));
        boolean notSorted = true;
        while (notSorted) {
            notSorted = false;
            for (int i = 1; i < numbersArray.length; i++) {
                if (numbersArray[i] < numbersArray[i - 1]) {
                    int tmp = numbersArray[i];
                    numbersArray[i] = numbersArray[i-1];
                    numbersArray[i-1] = tmp;
                    notSorted = true;
                }
            }
        }
        //Проходка с концов к центру
        int i = 0; // первый, то есть левый
        int j = numbersArray.length - 1; // второй, то есть правый
        while (i != j)
        {
            int n = numbersArray[i];
            int m = numbersArray[j];
            if (n + m < sum)
                i++;
            else if (n + m > sum)
                j--;
            else
            {
                System.out.println("N = " + Integer.toString(n) + ", M = " + Integer.toString(m));
                return;
            }
        }
        System.out.println("Не найденно");
    }
}
