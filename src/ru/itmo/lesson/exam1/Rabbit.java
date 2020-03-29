package ru.itmo.lesson.exam1;

import java.util.Date;
import java.util.Random;

public class Rabbit extends Pet implements CanBeEaten{
    Rabbit(){
        Random random = new Random(new Date().getTime());
        int health = random.nextInt(100)+100;
        this.health= health;
        this.MAX_HEALTH = health;
        this.weight =random.nextInt(5) +3;
        this.name="Кролик";
        this.speed = 30+random.nextInt(40);
    }
    @Override
    public int eat() {
        return this.kill();
    }
}
