package ru.itmo.lesson.exam1;

import java.util.Date;
import java.util.Random;

public class Redneck {
    public int resource = 5;
    public String name;

    Redneck(String name){
        this.name = name;
    }

    public void getResource(Pet[] pets){
        for (Pet pet: pets) {
            if (pet instanceof CanGetResourse){
                this.resource++;
                pet.resource--;
            }
        }

    }

    public void eatAnimal(Pet food){
        if (food instanceof CanBeEaten){
            resource+=((CanBeEaten) food).eat();
        }
    }

    public static boolean kickAss(Weak weak){
        Random random = new Random(new Date().getTime());
        if (weak instanceof Bear) {
            return false; // Этож медведь, он фермера сам задерёт
        } else
        return random.nextBoolean();
    }

    public void feedAnimals(Pet pet){
        Random random = new Random(new Date().getTime());
        pet.health++;
        if (pet.health>pet.MAX_HEALTH)
            pet.health=pet.MAX_HEALTH;
    }
}
