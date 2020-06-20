package ru.itmo.lesson.patterns.builder;

public class NutritionFacts {
    private final int servings;
    private final int calories;
    private final int fat;

    public static class Builder{
        // обязательные параметры
        private final int servings;
        //необязательные
        private int calories = 1;
        private int fat = 1;

        public Builder(int servings) {
            this.servings = servings;
        }

        //сеттеры для остальных
        public Builder calories(int  caloriesVal){
            calories = caloriesVal;
            return this;
        }
        public Builder fat(int  fatVal){
            calories = fatVal;
            return this;
        }
        public  NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder){
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
    }

}
