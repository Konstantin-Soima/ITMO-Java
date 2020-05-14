package ru.itmo.lesson.lesson11.enums;

import java.util.Arrays;

public class EnumExample {
    public static void main(String[] args) {
        //создание обьекта типа Article
        Article article = new Article("Путешествие по Австралии");
        article.setText("Текст статьи");
        article.setCountry(Country.AUSTRALIA);
        Article article2 = new Article("Энциклопедия Британика");
        article2.setText("Самая большая энциклопедия 19 Века");
        article2.setCountry(Country.UK);
        System.out.println(article);
        System.out.println(article2);
        //методы enum
        //получение массива констант values()
        Country[] countries = Country.values();
        System.out.println(Arrays.toString(countries));

        // Индекс элемента в массиве
        System.out.println(Country.UK.ordinal());

        for (Country country: countries){
            System.out.println("country: "+country.name()+" - "+country.ordinal());
        }

        //получение элемента enum по строке (нет - будет Excaption)
        System.out.println(Country.valueOf("USA"));

        //enum Priority
        int codeHigh = Priority.HIGH.getCode();
        System.out.println("codeHigh = "+ codeHigh);

        Priority low =Priority.LOW;
        low.setCode(0);
        System.out.println(Priority.LOW.getCode());

        Operation operation = Operation.MULTI;
        System.out.println(operation.action(2,6));
        operation = Operation.SUM;
        System.out.println(operation.action(2,6));

        //создать enum, который перечисляет планеты solar системы и возвращает массу планеты и её радиус
        Planet[] planets = Planet.values();
        System.out.println(Arrays.toString(planets));
        for (Planet planet: planets){
            System.out.println("planet: "+planet.name()+" - вес:"+planet.getWeight()+" r: "+planet.getRadius());
        }
    }
}
//enum - перечисление
enum Country {
    UK, USA, AUSTRALIA // Элементы enum - обьекты типа county
}

enum Priority {
    HIGH(10), MIDDLE(5), LOW(1);
    private int code;

    Priority(int code) {
        this.code = code;
    }

    public int getCode() { //доступен всем элементам
        return code;
    }

    public void setCode(int code) {//Изменит на всю программу
        this.code = code;
    }
}

enum Operation{
    SUM{
        @Override
        public int action(int a, int b) {
            return a+b;
        }
    }, MULTI{
        @Override
        public int action(int a, int b) {
            return a*b;
        }
    };
    public abstract int action(int a,int b);
}

enum Planet{
    MERCURY(10,10),VENUS(10,20),
    EARTH(30,30),MARS(60,30),JUPITER(1000,1000),
    SATURN(1000,1999),URANUS(300,200),NEPTUNE(200,100),
    PLUTO(10,5);
    private int weight;
    private int radius;
    Planet(int weight, int radius){
        this.weight=weight;
        this.radius=radius;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}