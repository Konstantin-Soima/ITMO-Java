package ru.itmo.lesson.exam1;

public class Rabbit extends Pet implements CanBeEaten{
    @Override
    public int eat() {
        return this.kill();
    }
}
