package ru.itmo.lesson;

import java.util.Scanner;

public class FirstLesson {
    //psvm создаёт в idea main
    //    коммменm ctrl+/ (только в En расскладке)
    /*мноострочный
    CTRL+SHIFT+/*/
    public static void main(String[] args) {
//        Есть два типа данных:
//        1. Примитивне:
//        byte -128 +127
        byte  byteVar;
        byte  byteVar1, byteVar2; //Ctrl+D копия строки
        byte  byteVar3 = 35;
        byte  byteVar4 = 20, byteVar5 = 45;
        byteVar = 10;
//        short - 2byte -32768 +32767
        short shortVar = 300;
        short shortVar2 = 200;
        int shortVar3 = shortVar + shortVar2; //short не складывается в short
//        int - 4 byte
        int intVar1  = 1000;
        int intVar2  = 2_000_000; //прочерк игнорируется компилятором
//        int zeroDivision = intVar1 / 0;

//          long = 8byte
        long longVar = 3000000000L; // L for Long
//        float - 4 byte
        float floatVar = 5.7f; //F for Float
        float floatVar2 = floatVar / 0;
        System.out.println(floatVar2); //sout - автозамена
//        double - 8 byte
        double doubleVar = -3.12;
        double doubleVar2 = doubleVar / 0;
        System.out.println(doubleVar2);
        //дз почему ненадёжны Float Double
        // TODO: 02.03.2020
        // FIXME: 02.03.2020

        //char - 2 byte номр символа в Юникоде UTF-16
        char charVar = 'に';
        System.out.println(charVar);
//        boolean - true/false
        boolean isActive = true;
        boolean isClosed = false;
//        2. Ссылочные

//      Приведение типов:
//        1.автоматическое
        byte someByte = 10;
        int someInt = someByte;
//        2.явное преведение типов
        someInt = 257;
        someByte = (byte)someInt;
        System.out.println(someByte);

//        Операторы присвоения
//        =  +=  -=  *=   /=  %=
        int a = 10;
        a += 7; //a = a +7
//        арифметическе операци
//        +  -  /   *  %
        // 7 % 2 = 1
        a = 12;
        int b = 7;
        int c = a / b;
        double c1 = (double) a / b; //это не работает без приведения одного из операндов к плавующей точке
        System.out.println(c);
        System.out.println(c1);

//        операторы сравнения
//        >  <  >=  <=  !=  ==
//        результпт true либо false
        boolean bool =  8 > 10; //false


        //инкремент и декремент
        a++; //постфиксня форма
        ++a; //префиксная форма
        b--;

        // Консоьный вывод
        System.out.println("Выводимая информация");
        System.out.printf("Форматированный вывод %s \n",charVar);
        //для дроби %f
        //для целых %d
        //для строк %s

        //Консольный ввод
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число:");
        int num = in.nextInt();
        System.out.printf("Вы ввели: %d\n",num);

//        Логическе операторы
//        Применяются к boolean переменным или выражениям
//        && and || or  ! not  ^ xor

//        Тернарный оператор
//          переменная = (условие) ? выражение1 : выражене 2;
        a = 2;
        b = 3;
        c = a < b ? a + b : a - b;

//        дана переменная типа int
//        чтное - /2 нечётное *2
        c = num % 2 == 0 ? num / 2 : num * 2;
        System.out.println(c);
    }
}
