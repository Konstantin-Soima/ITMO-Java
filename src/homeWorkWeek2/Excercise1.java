package homeWorkWeek2;

public class Excercise1 {
    public static void main(String[] args) {
        String word1 = "Чётное";
        String word2 = "Словце";
        String mix = word1.substring(0,word1.length()/2)
                .concat(word2.substring(word2.length()/2,word2.length()));
        System.out.println(mix);
    }
}
