package ru.spbexp.lesson.lesson7;

abstract public class BattleUnit
        extends Unit
        implements CanAttack {
    protected int attackScore;

    public BattleUnit(int healthScore, int speed, int attackScore) {
        super(healthScore, speed); // вызов конструктора родительского класса
        setAttackScore(attackScore);
    }

    public int getAttackScore() {
        return attackScore;
    }

    public void setAttackScore(int attackScore) {
        this.attackScore = attackScore;
    }

//    abstract public void attack(BattleUnit enemy);

    public void runFromField(){
        System.out.println("runFromField CanAttack");
    }
    //knight / doctor / infantry
    public static BattleUnit getBattleUnit(String type){
        BattleUnit battleUnit = null;

        if ("knight".equals(type)){
            int healthScore = (int)(Math.random()*10+2); //от 12 до 2
            int speed = (int)(Math.random()*7+1); //от 1 до 8
            int attackScore = (int)(Math.random()*8+1); //от 1 до 9
            int horseSpeed = (int)(Math.random()*13+3); //от 3 до 16
            battleUnit = new Knight(healthScore,speed,attackScore,horseSpeed);
        }
        else if ("doctor".equals(type)){
            int healthScore = (int)(Math.random()*10+2); //от 12 до 2
            int speed = (int)(Math.random()*7+1); //от 1 до 8
            int attackScore = (int)(Math.random()*8+1); //от 1 до 9
            int horseSpeed = (int)(Math.random()*13+3); //от 3 до 16
            battleUnit = new Doctor(healthScore,speed,attackScore,horseSpeed);
        }
        else if ("infantry".equals(type)){
            int healthScore = (int)(Math.random()*10+2); //от 12 до 2
            int speed = (int)(Math.random()*7+1); //от 1 до 8
            int attackScore = (int)(Math.random()*8+1); //от 1 до 9
            int horseSpeed = (int)(Math.random()*13+3); //от 3 до 16
            battleUnit = new Infantry(healthScore,speed,attackScore,horseSpeed);
        }

        return battleUnit;
    }
}
