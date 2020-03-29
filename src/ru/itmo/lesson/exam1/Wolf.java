package ru.itmo.lesson.exam1;

import java.util.Date;
import java.util.Random;

public class Wolf extends Weak {
    Wolf(){
        Random random = new Random(new Date().getTime());
        this.speed = 50+random.nextInt(10);
        this.name = "Волк";
        this.power = random.nextInt(speed)+1;
    }
}
