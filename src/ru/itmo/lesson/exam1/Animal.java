package ru.itmo.lesson.exam1;

abstract public class Animal {
    public String name;
    public int weight;
    public int speed;
    @Override
    public String toString() {
        return this.name;
    }
}
