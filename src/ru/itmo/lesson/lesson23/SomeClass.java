package ru.itmo.lesson.lesson23;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class SomeClass {
    public static void main(String[] args) {
        EventListener firstListener = new EventListener() {
            @Override
            public void greenEvent(int code) {
                System.out.println("реакция на green1");
            }

            @Override
            public void yellowEvent(int code) {
                System.out.println("реакция на yellow1");

            }

            @Override
            public void redEvent(int code) {
                System.out.println("реакция на red1");

            }
        };
        EventListener secondListener = new EventListener() {
            @Override
            public void greenEvent(int code) {
                System.out.println("реакция на green2");
            }

            @Override
            public void yellowEvent(int code) {
                System.out.println("реакция на yellow2");

            }

            @Override
            public void redEvent(int code) {
                System.out.println("реакция на red2");

            }
        };
        System.out.println(firstListener.getClass().getName());
        System.out.println(secondListener.getClass().getName());

        StateClass stateClass = new StateClass();
        stateClass.addListener(firstListener);
        stateClass.addListener(secondListener);

        Scanner scanner = new Scanner(System.in);
        String s;
        while (true){
            System.out.println("введите статус или exit");
            s = scanner.nextLine();
            if ("exit".equalsIgnoreCase(s)) break;
            stateClass.changeState(s);
        }
    }
}

interface EventListener{
    void greenEvent (int code);
    void yellowEvent (int code);
    void redEvent (int code);
}

class StateClass{

    private ArrayList<EventListener> eventListener = new ArrayList<>();
    public void addListener (EventListener listener){
        eventListener.add(listener);
    }
    public void removeListener(EventListener listener){
        eventListener.remove(listener);
    }
    public void okNotify(int code){
        eventListener.forEach(listener -> listener.greenEvent(code));
    }
    public void warningNotify(int code){
        eventListener.forEach(listener -> listener.yellowEvent(code));
    }
    public void errorNotify(int code){
        eventListener.forEach(listener -> listener.redEvent(code));
    }
    public void changeState(String value){
        if ("ok".equalsIgnoreCase(value)) okNotify(1);
        else if ("warn".equalsIgnoreCase(value)) warningNotify(5);
        else if ("error".equalsIgnoreCase(value)) errorNotify(10);
    }
}