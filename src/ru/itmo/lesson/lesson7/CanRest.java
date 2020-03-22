package ru.spbexp.lesson.lesson7;

public interface CanRest {
    void rest();

    default void runFromField(){
        System.out.println("runFromField CanRest");
    }
}
