package ru.itmo.lesson.lesson17;

//ДЗ: мапы, enum коллекции

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesClass {
    public static void main(String[] args) {
    //Обьект основан на хэш таблицк
        ///исп для хранения пар: ключ-значение
        //Ключ и значения типа String
        Properties properties = new Properties();

        //файл example.properties в /sources  (папку надо отмечать как ресурсную)
        try (InputStream input = PropertiesClass.class.getClassLoader()
                .getResourceAsStream("example.properties")){
            properties.load(input);
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(properties.getProperty("key"));
        System.out.println(properties.getProperty("age"));
        System.out.println(properties.getProperty("tst"));
        System.out.println(properties.getProperty("tst","work"));
        properties.setProperty("ip","127.0.0.1");

        PropertiesLoader loader1 = PropertiesLoader.getPropertiesLoader("example.properties");
        PropertiesLoader loader2 = PropertiesLoader.getPropertiesLoader("example.properties");

    }
}
