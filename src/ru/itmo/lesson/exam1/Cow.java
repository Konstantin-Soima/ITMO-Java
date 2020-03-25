package ru.itmo.lesson.exam1;

import java.util.Date;
import java.util.Random;

public class Cow extends Pet implements CanBeEaten,CanGetResourse {

    Cow(){
        Random random = new Random(new Date().getTime());
        int health = random.nextInt(100)+100;
        this.health= health;
        this.MAX_HEALTH = health;
        this.weight =random.nextInt(150) +300;
        this.resource = weight/2;
        this.name="Корова";
    }
    @Override
    public int eat() {
        return this.kill();
    }
}
