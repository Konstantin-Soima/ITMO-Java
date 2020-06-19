package ru.itmo.lesson.lesson26;

import java.util.concurrent.*;

public class TstPool {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(2, //основное число потоков
                5, //максимальное количество
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(20));
    }
}
 class SomeExecutor extends  ThreadPoolExecutor{
    public SomeExecutor(int corePoolSize, int maximimPoolSize,
                        long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue){
        super(corePoolSize,maximimPoolSize,keepAliveTime,unit,workQueue);
    }

     @Override
     protected void afterExecute(Runnable r, Throwable t) {
         super.afterExecute(r, t);
     }

     @Override
     protected void beforeExecute(Thread t, Runnable r) {
         super.beforeExecute(t, r);
     }

     @Override
     public void shutdown() {
         super.shutdown();
     }
 }