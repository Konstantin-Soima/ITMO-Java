package ru.itmo.lesson.lesson26;

import java.util.concurrent.*;

public class ThreadsPool {
    public static void main(String[] args) {
        ExecutorService fixedPool = Executors.newFixedThreadPool(2);

        for (int i =0; i < 10; i++){
            fixedPool.execute(new RunnableTask("fixedPool"));
        }
        //shutdown - дожидается выполнения текущих задач и не принимает новых
        fixedPool.shutdown();

        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        singleThread.execute(new RunnableTask("singleThtread"));
        singleThread.execute(new RunnableTask("singleThtread"));
        singleThread.shutdown();

        //отложенное выполнение
        ScheduledExecutorService poolD = Executors.newSingleThreadScheduledExecutor();
        poolD.schedule(new RunnableTask("poolD"),5, TimeUnit.SECONDS);
        poolD.shutdown();

        ScheduledExecutorService everyFiveSecond = Executors.newSingleThreadScheduledExecutor();
        everyFiveSecond.scheduleAtFixedRate(new RunnableTask("everyFiveSecondAfterStart"),0,5,TimeUnit.SECONDS);
        ScheduledExecutorService everyFiveSecondsAfterEnd = Executors.newSingleThreadScheduledExecutor();
        everyFiveSecondsAfterEnd.scheduleWithFixedDelay(new RunnableTask("everyFiveSrcondAfterEnd"),
                0,
                5,
                TimeUnit.SECONDS);
        everyFiveSecondsAfterEnd.shutdown();
    }
}
class RunnableTask implements Runnable{
    private  String poolName;

    public RunnableTask (String poolName){
        this.poolName = poolName;
    }

    @Override
    public void run() {
        System.out.println("Поток "+ Thread.currentThread().getName() + " Из пула " + poolName);
        try{
            Thread.sleep(800);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}