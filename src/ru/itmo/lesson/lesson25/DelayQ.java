package ru.itmo.lesson.lesson25;

import javax.swing.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;



//ДЗ
/*
Есть обьект, обьект формируется в первом потом идёт в 2й, третий, исходный
перемещается обьект "Заквз"
3 класса /3Потока
Клиент (создаёт заказ)
Официант
Повар

Очереди:
1 клиент- официант
2 официант - повар
3 повар клиент
*/
public class DelayQ {
    public static void main(String[] args) {

        DelayQueue<Action> actions = new DelayQueue<>();
        actions.put(new Action(LocalDateTime.now(), ()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("OLD TASK");
        }));
        actions.put(new Action(LocalDateTime.now().plusMinutes(2), ()->{
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Future TASK");
        }));
        actions.put(new Action(LocalDateTime.now().plusMinutes(3), ()->{
            try {
                Thread.sleep(300);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Future TASK 2");
        }));
        actions.put(new Action(LocalDateTime.now().plusMinutes(-2), ()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("old TASK 2");
        }));

        while (true){
            try {
                new Thread(actions.take().getRunnable()).start();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
class Action implements Delayed{
    private LocalDateTime dateTime;
    private Runnable runnable;

    public Action(LocalDateTime dateTime, Runnable runnable){
        this.dateTime = dateTime;
        this.runnable = runnable;
    }
    public Runnable getRunnable(){
        return runnable;
    }

    //если get delay > 0 то ничего .take из очереди не возьмёт

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(Duration.between(LocalDateTime.now(),dateTime).toSeconds(),TimeUnit.SECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return dateTime.compareTo(((Action)o).dateTime);
    }
}