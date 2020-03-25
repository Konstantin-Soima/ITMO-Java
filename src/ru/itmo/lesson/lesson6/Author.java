package ru.itmo.lesson.lesson6;

public class Author { //Порядок: св-ва, конструкторы, геттеры/сетторв, остальное
    //свойства
    private String name; //по умолчанию public
    private String surename;
//методы
    public void setName(String name) {
        //длинна от двух
        if (name.length()<2 || "".equals(name)) return; //Сначала должна быть та строка, которая гарантированно меет значение
        this.name = name;//this - указание на статичный обьект
    }
//геттер - возвращает значение св-ва
    public String getName() {
        return name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surename='" + surename + '\'' +
                '}';
    }
}
