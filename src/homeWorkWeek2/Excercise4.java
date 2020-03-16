package homeWorkWeek2;

import java.util.Arrays;

public class Excercise4 {
    public static void main(String[] args) {
        String polindrome = "кобан упал и лапу на бок";
        boolean isPolyndeome = checkPolindrome(polindrome);
        System.out.println(isPolyndeome?"Это полиндром":"Это не полиндром");
    }
    private static boolean checkPolindrome (String word){
        boolean equal = true;
        char[] letters= word.replaceAll("[^a-zA-Zа-яА-Я]", "").toCharArray();
        for (int i = 0; i < letters.length; i++){
            equal = equal & (letters[i]==letters[letters.length-i-1]);
        }
        return equal;
    }
}
