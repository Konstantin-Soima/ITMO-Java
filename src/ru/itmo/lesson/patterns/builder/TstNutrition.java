package ru.itmo.lesson.patterns.builder;

public class TstNutrition {
    public static void main(String[] args) {
        NutritionFacts apple = new NutritionFacts.Builder(4)
                .calories(200)
                .fat(4)
                .build();
        System.out.println(apple);
    }
}
