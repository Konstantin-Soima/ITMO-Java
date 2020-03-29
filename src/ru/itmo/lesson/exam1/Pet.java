package ru.itmo.lesson.exam1;

public class Pet extends Animal implements CanRest,CanEscape{
    public int health;
    public int MAX_HEALTH;
    public int resource = 0;
    public boolean onFarm = true;
    @Override
    public void rest() {
        if (health<MAX_HEALTH) health++;
    }

    public int kill(){
        this.onFarm = false;
        return this.weight;
    }

}
