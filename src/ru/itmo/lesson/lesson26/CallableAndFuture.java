package ru.itmo.lesson.lesson26;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Function;

public class CallableAndFuture {
    public static void main(String[] args) {
        ExecutorService unitPool = Executors.newFixedThreadPool(3);
        Callable<Unit> unitCallable = new UnitCreator();
        ArrayList<Future<Unit>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Future<Unit> future = unitPool.submit(unitCallable);
            futures.add(future);
        }

//        for (Future<Unit> future: futures){
//            System.out.println("Waiting Future...");
//            try {
//                System.out.println("Unit "+future.get());
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
        for (Future<Unit> future: futures){
            System.out.println("Waiting Future...");
            try{
                System.out.println("Unit "+future.get((long)(Math.random()*3000),TimeUnit.MILLISECONDS));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println("--не смог дождаться юнита--");
                e.printStackTrace();
            }
        }
    }
}

class Unit{
    private String name;
    private int health;
    private int attack;

    public String getName(){
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setName(String name){
        this.name = name;
    }
}

class UnitCreator implements Callable<Unit>{ //этот поток не новая многопоточность
    @Override
    public Unit call() throws Exception {
        //Поток спит не более 5000млс
        Random random = new Random();
        Thread.sleep(random.nextInt(5000));
        Unit unit = new Unit();
        unit.setName(Thread.currentThread().getName());
        //Рандом здоровье не больше 20
        //рандом атака не больше 15
        unit.setHealth(random.nextInt(20) + 1);
        unit.setAttack(random.nextInt(15) + 1);
        return null;
    }
}