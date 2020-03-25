package ru.itmo.lesson.lesson5;

import java.util.Arrays;

public class StringLesson {
    public static void main(String[] args) {
        //Строки - ссылочный тип
        //до 9 версии
        char charVar = 'e';
        String someString = "jjd";
        char[] chars = {'j','j','d'};
        //строки хранятся как массив Char
        //UTF-16 кодировка по умолчанию

        //строки после 9
        //строки хранятся как массив byte[]
        //+ хранится кодировка UTF 16 или Latin-1
        String string = "Some string";
        String string2 = new String("Some string");
        String string3 = new String("Some string");
        String string4 = "Some string";

        //Сравнение строк
        System.out.println(string == string4);
        System.out.println(string2 == string3);
        System.out.println(string2.equals(string3));
        String newString = new String("new");
        String newString2 = newString.intern(); //возвращает ссылку, сначала попытавшись занести в пул строк

        System.out.println(string2=string3);
        System.out.println(string2.intern()==string3.intern());

        //Конкотинацмя строк
        //Строчки в языке е меняются, любые изменения приводят к созданию новой записи
        String str1 = "strika 1";
        String str2 = "strika 2";
        String str3 = "strika 3";

        str1 = str1 + " " +str2;
        System.out.println(str1);
        str2 = str2.concat(str3).concat("Hello")
                .concat("STR");

        //Кажый + и каждый conca создаёт строку в пуле.
        System.out.println("тоже хранится в пуле");

        str3 = String.join(" :: ", str1,str2,str3);
        System.out.println(str3);

        str1 = "строка ";
        for (int i = 0; i<10; i++){
            str1 +="инетрация" + i;
        }
        System.out.println(str1);
        //В цыклах ни + ни конкаи не используется
        //StringBuilder или String Buffer
        //Stringbuilder - работает быстреее, но не потоко ьезпасен
        //String Buffer - наоборот
        str1 = "Stroka";
        StringBuilder sb =new StringBuilder(str1);
        sb.append( str1).append("hello");
        for (int i = 0; i<10; i++){
            sb.append("инетрация").append(i);
        }
        str1 = sb.toString();
        System.out.println(str1);

        char[] charsArr = {'q','w','e'};
        String charStr = new String(charsArr);

        byte[] bytes = charStr.getBytes();
        System.out.println(Arrays.toString(bytes));
        charStr = new String(bytes);

        //сравнение
        str1 = "Java";
        str2 = "java";

        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));

        System.out.println(str1.compareTo(str2));
        System.out.println(str1.compareToIgnoreCase(str2));//Сравнение посимвольно до первого расхождения

        str1 = "Java";
        System.out.println(str1.startsWith("Ja"));
        System.out.println(str1.endsWith("A"));

        str1 = str1.toLowerCase();
        System.out.println(str1);
        str1 = str1.toUpperCase();
        System.out.println(str1);

        str1 = "      stroka   ";
        System.out.println(str1.trim());
        System.out.println(str1.trim().length());

        str1 = "Java";
        System.out.println(str1.replace("a","AA"));

        str1 = "Java Junior";
        String[] strings = str1.split("\\s");
        System.out.println(Arrays.toString(strings));
    }
}
