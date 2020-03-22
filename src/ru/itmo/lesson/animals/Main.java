package ru.spbexp.lesson.animals;

public class Main {
    public static void main(String[] args) {
        CanBeEaten var1 = new Mouse();
        CanEat var2= new Wolf();
        var1.beEaten(var2);
    }
}
