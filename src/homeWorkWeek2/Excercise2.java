package homeWorkWeek2;

import java.util.Arrays;

public class Excercise2 {
    public static void main(String[] args) {
        String sentence = "Длинное предложение со словами разной, а может (скорее всего) и нет, длинны";
        String[] words = sentence.split("\\s|,|\\.|-|\\(|\\)");
        int max = 0;
        int longestIndex = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length()>max) {
                max = words[i].length();
                longestIndex = i;
            }
        }
        System.out.println("Самое длинное слово: " + words[longestIndex]);
    }
}
