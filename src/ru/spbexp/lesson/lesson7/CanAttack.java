package ru.spbexp.lesson.lesson7;

public interface CanAttack {
    void attack(BattleUnit enemy);

    default void runFromField(){
        System.out.println("runFromField CanAttack");
    }
}
