package ru.itmo.lesson.lesson11.gc;

public class TstMessage {

    public static void main(String[] args) {
        //Stack вызов работает по принципу LIFO
        //1. main
        //2. printStart
        String data = "Срочное сообщение";
        //
        int num = 10;

        printStart();

        Message message = new Message();
        message.setText(data);
        message.setCode(num);

    }

    private static void printStart(){

        System.out.println("START");
        //  object create in Heap memory
        Message message = new Message();
        // another object created in Heap memory
        message = new Message();
        // обнуление ссылки (не удаляется обьект)
        message = null;


        //деление облостей Хипа на молодое поколение
        //промежуточная область и старое поколение
        //сборщик мусора собирает из молодого
        //после ввыжевшие перенесли в s0 промежуточный
        //потом работает в молодом + so в S1
        //потом в старое суёт что осталось

    }
}
