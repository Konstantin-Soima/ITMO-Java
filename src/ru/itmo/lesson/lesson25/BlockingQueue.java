package ru.itmo.lesson.lesson25;

import java.awt.font.TextHitInfo;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueue {
    public static void main(String[] args) {
         //put -> [8] -> get метод 9й не запихнёт, места нет
        //put - take
        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<>(10);
        ArrayBlockingQueue<String> strings2 = new ArrayBlockingQueue<>(10,true);

        LinkedBlockingQueue linkedBlockingQueue;
        LinkedBlockingDeque linkedBlockingDeque;

        LinkedBlockingDeque<Signal> signals = new LinkedBlockingDeque<>(20);

        new Thread(new GetSignal(signals)).start();
        new Thread(new PutSignal(signals)).start();
    }
}

class PutSignal implements Runnable{
    private LinkedBlockingDeque<Signal> signals;
    public PutSignal(LinkedBlockingDeque<Signal> signals) {
        this.signals = signals;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("PutSignal "+ Thread.currentThread().getState());

            try{
                Thread.sleep(5000);
                Signal signal = Signal.getSignal();
                signals.put(signal);
                System.out.println("PutSignal "+signal);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class GetSignal implements Runnable{
    private LinkedBlockingDeque<Signal> signals;

    public GetSignal(LinkedBlockingDeque<Signal> signals){
        this.signals = signals;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("GetSignal "+Thread.currentThread().getState());
            try{
                System.out.println("Get Signal " + signals.take()); //take заставит ждать элемент

            }catch (InterruptedException e){
                //Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}

class Signal {
    enum Priority {
        HIGH, MEDIUM, LOW;
        public static Priority getPriority(int ord){
            for (Priority priority: values()){
                if (ord == priority.ordinal()){
                    return priority;
                }
            }
            throw new AssertionError("wrong ordinal");
        }
    }

    private Priority priority;
    private int code;

    public Signal(Priority priority, int code) {
        this.priority = priority;
        this.code = code;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Signal{" +
                "priority=" + priority +
                ", code=" + code +
                '}';
    }

    public static Signal getSignal(){
        Random random = new Random();
        return new Signal(
                Priority.getPriority(random.nextInt(Priority.values().length)),
                random.nextInt(30)
        );
    }
}