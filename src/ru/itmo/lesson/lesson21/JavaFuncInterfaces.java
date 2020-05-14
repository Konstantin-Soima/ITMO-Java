package ru.itmo.lesson.lesson21;

import java.util.function.Function;
import java.util.function.Predicate;

public class JavaFuncInterfaces {
    public static void main(String[] args) {
         //интерфейс Predicate<T>
        Predicate<Integer> pos = num -> num > 0;
        Function<Integer,Integer> plusTen = num ->num+10;
        Function<Integer,Integer> plusFive = num ->num+5;

        double doubleREs = plusFive.andThen(plusFive).apply(16);
        System.out.println("doubleRes: "+doubleREs);

        Function<Integer,String> addDollar = dollar -> dollar.toString()+"$";
        System.out.println(addDollar.apply(100));

        Predicate<Integer> cond = num -> num >0;
        Function<Integer,Integer> func = getFunction(cond,plusFive,plusTen);
        System.out.println(func.apply(5));
    }

    static Function<Integer,Integer> getFunction(Predicate<Integer> condition,
                                                 Function<Integer,Integer> ifTrue,
                                                 Function<Integer,Integer> ifFalse
    ){
        return num -> condition.test(num) ? ifTrue.apply(num):ifFalse.apply(num);
    }
}
interface getFunction {
    double execute(double a, double b);
}
