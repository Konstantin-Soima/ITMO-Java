package homeWorkWeek2;

public class Excercise3 {
    public static void main(String[] args) {
        String string = "Hahahaha";
        String pattern = "haha";
        int count = 0;
        for (int i = 0; i <= string.length()-pattern.length(); i++){
            if (string.substring(i,pattern.length()+i).equalsIgnoreCase(pattern)){
                count++;
            }
        }
        System.out.printf("Количество вхождений: %d",count);
    }
}
