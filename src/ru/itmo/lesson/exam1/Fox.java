package ru.itmo.lesson.exam1;

import java.util.Date;
import java.util.Random;

public class Fox extends Weak{
    Fox(){
        Random random = new Random(new Date().getTime());
        this.speed = 50+random.nextInt(17);
        this.name = "Лиса";
        this.power = random.nextInt(speed)+1;
    }
}
