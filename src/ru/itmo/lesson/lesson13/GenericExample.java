package ru.itmo.lesson.lesson13;

import java.util.Comparator;

public class GenericExample {
    public static void main(String[] args) {
        //в <> конкретный тип данных вместо Т
        User<String> user1 = new User<>();
        user1.setId("erertre");
        user1.setLogin("dfdf");
        user1.setPwd("wwww");

        //в Generic нельзя примитивы
        User<Integer> user2 = new User<>();
        user2.setId(12);
        user2.setLogin("1212");
        user2.setPwd("@12");


        PairContainer<String,Integer> container1 = new PairContainer<>("qwe",12);
        PairContainer<Double, User> container2 = new PairContainer<>(3.3,user1);
        //generic в User средой воспринимается как object
        container2.getValue().setId(12);
        container2.getValue().setId("dfdf");

        PairContainer<Double, User<String>> container3 =new PairContainer<>(4.6,user1);
        container3.getValue().setId("34343");

        Comparator comp = new SomeComp();
        Object a = 12;
        Object b = 12;
        int res = comp.compare(a,b);   //Смотри байткод
    }
}


///Есть Синтетические методы - они создаются компилятором
//synthetic bridge compare - связывает вызов и оригинальный класс
class  SomeComp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2){
        return  Integer.compare(o1,o2);
    }

}