package ru.itmo.lesson.animals;

public class Cat implements CanEat,CanBeEaten {

    @Override
    public void beEaten(CanEat weak) {
        System.out.println("Кота сьел "+weak);
    }

    @Override
    public void eat(CanBeEaten enemy) {
        System.out.println("Кот сьел "+enemy);
    }
}
