package ru.itmo.lesson.lesson12;

import java.io.IOError;
import java.io.IOException;

public class ExcetionLesson {
    public static void main(String[] args) {
        //Exception - это обьект
        //Error - не обработать в коде, всегда что-то с кодом
        //Exception - можно предугадать и исправить
        /*все исключения 2 вида:
        * 1. Runtime Exception - можем но не обязаны
        *
        *2. Исключения времени компиляции, обрабатывать обязательно
        *
        *
        * */

        //некоторые runtime Exception
        int a = 12;
        int b = 0;
        int res;
//        res = a/b;
//        Exception in thread "main" java.lang.ArithmeticException: / by zero
//        at ru.itmo.lesson.lesson12.ExcetionLesson.main(ExcetionLesson.java:20)
        int[] arr = new int[3];//
//        arr[39] = 12;
//        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 39 out of bounds for length 3
//        at ru.itmo.lesson.lesson12.ExcetionLesson.main(ExcetionLesson.java:24)

        String string = null;
 //       string.equals("hello"); //null.equals("hello");
//        java.lang.NullPointerException

        Object someData = "253";
        Integer someInteger;

       // someInteger=(Integer) someData; Ошибка приведения типа
//        java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')

//обработка исключений (checked и unckecked)
//для обработки - try catch блок
        try{
            System.out.println("before a/b");
            res = a / b;
            System.out.println("after a/b");
        }
        catch (ArithmeticException e){ //блок ловит только ошибку указанного типа
            System.out.println(e.getMessage());
            e.printStackTrace();
            res = 1000;
        }
        System.out.println("After try catch");
        System.out.println("res = " + res);
        //1 Кажому своё
        try {
            if (System.currentTimeMillis() % 2 ==0) someInteger=(Integer) someData;
            else arr[77]=666;
        }
        catch (ClassCastException e){
            System.out.println("Проблема типов");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Проблема масива");
        }
        //2 один для всех
        try {
            if (System.currentTimeMillis() % 2 ==0) someInteger=(Integer) someData;
            else arr[77]=666;
        }
        catch (ClassCastException | ArrayIndexOutOfBoundsException e){
            System.out.println("Проблема типов или масивов");
        }
        //3 общий
        try {
            if (System.currentTimeMillis() % 2 ==0) someInteger=(Integer) someData;
            else arr[77]=666;
        }
        catch (RuntimeException e){
            System.out.println("Проблема типов или масивов");
        }
        //finaly не обязателен
        finally {
            //выполняется всегда
            //обычно для закрытия ресурсов
        }



        voidWithUnckeckedException(40);
        //voidWithUnckeckedException(10);

        try {
            //обрабатываемое обязаны обернуть в try или пробросить выше
            voidWithCheckedException("asd.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        SomeMessage someMessage = null;
        try {

           someMessage =new SomeMessage("Название", "Текст");
        }
        catch (ChatException e){
            try {
                voidWithCheckedException("file.text");
            } catch (IOException ex){
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        // если выше ошибка то java.lang.NullPointerException
        System.out.println(someMessage.getText());
    }

    private static  void voidWithCheckedException(String s) throws IOException{
        if (s.endsWith("txt")){
            //генерируем обрабатываемое
            throw new IOException("Проблема с файлом");
        }
        System.out.println("s = " + s);
    }

    private static void voidWithUnckeckedException(int a){
        if (a<15){
            //генерируем исключение и выбрасываем (throw)
            throw new IllegalArgumentException("Значение должно быть больше 15");

        }
        System.out.println("a = " + a);
    }
}
