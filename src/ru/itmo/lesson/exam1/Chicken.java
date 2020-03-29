package ru.itmo.lesson.exam1;

import java.util.Date;
import java.util.Random;

public class Chicken extends Pet implements CanBeEaten, CanGetResourse{
    Chicken(){
        Random random = new Random(new Date().getTime());
        int health = random.nextInt(100)+100;
        this.health= health;
        this.MAX_HEALTH = health;
        this.weight =random.nextInt(3) +3;
        this.resource = random.nextInt(12); //дюжина яиц пока не начнёт высиживать
        this.name="Курица";
        this.speed = 10+random.nextInt(10);
    }
    @Override
    public int eat() {
        return this.kill();
    }
}
