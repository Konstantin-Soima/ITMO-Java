package lesson9;

import org.w3c.dom.ls.LSOutput;

public class PrimitiveWrapper {
    public static void main(String[] args) {
        // Примитивные типы данных:
        // byte | short |int | float | double | char
        // имеют люёртки
        // byte - Byte
        // short - Short
        // int - Integer
        // long - Long
        // float - Float
        // double - Double
        // char - Character
        // boolean - Boolean
        //приоритет за приметивами, это память экономит, исключение:
        //1. когда примитивы использовать невозможно
        //2. когда нужны методы обёрток

        int count = 267; //создали переменную типа int
        //Integer age = new Integer(200); Не принято
        Integer age = 200;

        // автоупоковка и автораспоковка
        //автоупоковка - переменной класса обьекта присваивается примитив
        Integer num = count;
        //Автораспоковка - когда примитиву приводит
        double price;
        Double someDouble = 25.12;
        price = someDouble;

        //Правила:
        //1. Автоупоковка требует совпадение типов
        byte one = 1;
        //num = one; уже не работает
        num = (int) one;
        // на распоковку не распространяется
        Byte two = 2;
        int num2 = two;

        //2. параметры методов подлежат правилам автоупоковки/распоковки
        int c = 4;
        sqr(c);

        //3. Автоупоковка/распоковка не работает с массивами
        double[] doubles = {3.14, 5.56,7.62};
        //pintArray(doubles) Не сработает

        // Методы обёрток
        // возврращают byte,int,long...
        byte intToByte = num.byteValue(); //вернёт примитив
        num.floatValue();
        num.longValue();

        //Строку с числом к числу
        //parseXXX(строка с числом) вернёт примитив
        //valueOF(строка с числом) возврат обьекта

        System.out.println(Byte.parseByte("2")); //byte
        System.out.println(Byte.valueOf("2")); //Byte


        //System.out.println(Integer.parseInt("2 дваа")); //exception

        //Сравнения
        //диапахон [-128;127]
        Integer first = 45;
        Integer second = 45;
        System.out.println("45 + 45" + (first == second)); //сравнение обьектов (но обьект один и тот же в кэше)

        //вне диапазон [-128;127]
        Integer fourth = 1488;
        Integer fifth = 1488;
        System.out.println("1488? " + (fourth == fifth));//false для них кэша нет сравнение ссылок

        //Правильно
        System.out.println(fourth.compareTo(fifth));
    }

    private static void sqr (Integer input){
        Integer squar = input * input;
        System.out.println(squar);
    }

    private static void pintArray (Double[] arr){
        for (Double doubl: arr)
        {
            System.out.println(doubl);
        }
    }


}
