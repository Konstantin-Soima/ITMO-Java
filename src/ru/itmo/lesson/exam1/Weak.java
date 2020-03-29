package ru.itmo.lesson.exam1;

import java.util.Date;
import java.util.Random;

public class Weak extends Animal {
    public int power;
    private int farmVisit = 0;
    final int MAX_VISIT = 3;


    public boolean eat(Pet pet){
        boolean win = false;
        if (farmVisit<MAX_VISIT) {
            if (pet.speed <= this.speed) { //если животное медленное начинается игра
                Random random = new Random(new Date().getTime());
                if (Redneck.kickAss(this)) {
                    farmVisit++;
                }
                else {
                    win = random.nextBoolean(); //шансов 50/50
                    if (win){
                        pet.kill();
                    }
                    else
                        {
                        pet.health-=power;
                        if (pet.health<=0){ //добил иначе зачем он ещё ранил
                            win = true;
                        }
                    }
                }
            }
        } else {
            System.out.println(this.name + " боиться возвращаться на ферму");
        }
        return win;
    }
}
