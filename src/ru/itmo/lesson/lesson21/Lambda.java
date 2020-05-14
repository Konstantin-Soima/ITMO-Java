package ru.itmo.lesson.lesson21;

public class Lambda {




    public static void main(String[] args) {
        //лямбда - реализация метода интерфейса

        //Реализация метода с сохранением в переменную
        //Operation operation = реализация метода
        Operation plus = (n,m) -> n+m;
        //1  один аргумент можно не брать в скобки
        //2 остальное число со скобками
        //3 тип аргументов из интерфейса
        // если в одну строчку тела то по умолчанию ретурн
        Operation division = (a,b) ->{
            if (b==0) throw new IllegalArgumentException("0!!!");
            return a / b;
        };
        System.out.println(plus.execute(34,134));
        System.out.println(Calculator.calculate(100,50,division));
        //Это не онанимная функция
        System.out.println(Calculator.calculate(10,10 , (a, b)->a-b));
    }
}
//интерфейсы у которых только один абстрактный метод называются функциональными
@FunctionalInterface //можно и не писать если методы абстрактные
interface Operation {
    double execute(double a, double b);
}

class Calculator{
    public static double calculate(double a, double b, Operation operation){
        return operation.execute(a,b);
    }
}
