package ru.itmo.lesson.lesson7;

public class King extends Unit {
    private int gold;

    public King(int healthScore, int speed) {
        super(healthScore, speed);
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public void rest() {
        System.out.println("Король на отдыхе");
    }

}
