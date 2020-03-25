package ru.itmo.lesson.lesson8;

//оператор final с классом запрещает наследование от данного класса
public  class CalcUtils {
    //здначение final переменных либо сразу определяется, либо в конструкторе
    final double Pi = 3.14159;
    final double SHORT_PI; //константы с больших буквчерез _
    public CalcUtils(){
        SHORT_PI=3.14;
    }
    static final double PI; //константиа

    //cтатичекский блок
    static {
        PI=3.4;
    }
    public static int summ (int a, int b){ //Утилитарный (обслкуживающи)  метод
        //в статических методах мы не можем обращаться к нестпттическим.
        return  a+b;
    }//фабричные создают обект



    //final методы нельзя переопределить
    //в дочерних классах
    //final аргументы в методе доступны только для чтения
    public final void someVoid( final int num, final SomeClass sc, final int[] arr){
        System.out.println(num);
        //num=90; //NOT WORK
        System.out.println(sc);
        System.out.println(sc.name);
        sc.name = "New Name";
        //sc = new SomeClass(); //Нельзя переопределить обьект, но можно изменять его свойства.
        arr[4] = 34;

    }
    //Наследование невозможно, т.к. родитель был final class
//    public class Child extends CalcUtils{
//        @Override
//        public void someVoid() { // <-- NOT WORK!
//            super.someVoid();
//        }
//    }
}

class  SomeClass{
    String name;
}
