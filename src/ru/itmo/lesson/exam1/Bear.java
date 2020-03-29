package ru.itmo.lesson.exam1;

import java.util.Date;
import java.util.Random;

public class Bear extends Weak {
    Bear(){
        Random random = new Random(new Date().getTime());
        this.speed = 40+random.nextInt(20);
        this.name = "Медведь";
        this.power = random.nextInt(speed)+1;
    }
}
