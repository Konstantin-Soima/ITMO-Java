package ru.itmo.lesson.lesson23;

public class Threads {
    //Потоки это обьекты типа Thread
    public static void main(String[] args) {
        //жизненый цикл потока
//        1 - создание потока
//            2. - поток готов к работе
//                3 - поток запущен
//            4- non runable (Time waiting/waiting/blocked) - состояние ожидание
//        5 - Terminated - поток завершил работу

        // Варианты описания потоков и из инструкций
        // 1. создание класа, который наследуется от класса Thread
        // 2.

        //первый вариант - создание класса, каждый наследуется от класса Thread
        FirstThread firstThread = new FirstThread();
        System.out.println(firstThread.getName() + ": "+firstThread.getState());
        firstThread.start(); //вызов метода старт - не равен вызову метода run


        SecondThread secondThread = new SecondThread();// THIS - NOT THREAD
        Thread secThread = new Thread(new SecondThread());
        secThread.start();


        //третий вариант  -лямбда
        Thread thridThread = new Thread(()->{
            System.out.println("ThridThread is Alive" + Thread.currentThread().isAlive());
        });



        Thread threadOne = new Thread(new SecondThread());

        Thread threadTwo = new Thread(new SecondThread());
        Thread threadThree = new Thread(new SecondThread());
        threadOne.setPriority(1);
        threadTwo.setPriority(5);
        threadThree.setPriority(Thread.MAX_PRIORITY);

        threadOne.start();
        threadThree.start();
        threadTwo.start();

        try{
            threadOne.join();
            threadTwo.join();
            threadThree.join();

        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("Основной поток "+Thread.currentThread().getName());

        //Поток останавливается если:
        //1 - выполнил все инструкции
        //2 - было выброшенно необработаное исключение
        //3 - остановилась jvm
        //4 - поток был демон и все не демон завершили работу

        FirstThread daemon = new FirstThread();
        //поток завершает работу когда все демоны завершат
        daemon.setDaemon(true);

        Thread actions = new Thread(()->{
while (!Thread.currentThread().isInterrupted()){
    System.out.println("some action...");
}
            System.out.println("After While");
        });

        actions.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        actions.interrupt();

    }
}


class FirstThread extends Thread{
    @Override
    public void run() { //инструкции потока
        // когда мето run будет вызван
        // инструкции начнут выполняться в отдельном потоке
        // не вызывать из кода!!! не путать с методом start()
        Thread.currentThread().setName("First Thread");
        System.out.println(Thread.currentThread().getName()+ ": "+ Thread.currentThread().getState());

    }
}
//второй вариант - создание класса с инструкциями для потока
//который имплементирует Runable
class SecondThread implements Runnable {
    @Override
    public void run(){
        for (int i = 0; i<3;i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}