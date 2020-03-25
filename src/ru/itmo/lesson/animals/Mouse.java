package ru.itmo.lesson.animals;

public class Mouse implements CanBeEaten {

    @Override
    public void beEaten(CanEat weak) {
        System.out.println("Мышь сьел "+weak);
    }
}
