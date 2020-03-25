package ru.itmo.lesson.animals;

public class Wolf implements CanEat {

    @Override
    public void eat(CanBeEaten enemy) {
        System.out.println("Волк сьел "+enemy);
    }
}
