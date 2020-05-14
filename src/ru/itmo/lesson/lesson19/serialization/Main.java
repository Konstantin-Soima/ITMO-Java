package ru.itmo.lesson.lesson19.serialization;

import java.io.*;

public class Main  {
    public static void main(String[] args) {

        Pupil pupil1 = new Pupil();
        pupil1.setAge(7);
        pupil1.setName("pupil1");
        pupil1.setGroup(new Group("Химия", 12));
        pupil1.learn();

        Pupil pupil2 = new Pupil();
        pupil2.setAge(8);
        pupil2.setName("pupil2");
        pupil2.setGroup(new Group("Биология", 22));
        pupil2.learn();

        Director director = new Director("Super Speech");
        director.setAge(44);
        director.setName("director");
        director.setRating(2);
    //Обьект в байты - серелизация
        //Байты в обьект - десерелизация
        //Serializable по умолчанию сарелизует всё, но можно исключать
        File file = new File("school.bin");
        System.out.println("До записи "+ pupil1);
        objectToFile(file,pupil1);
        objectToFile(file,pupil2);
        Pupil pupilFromFile = (Pupil) getObjectFromFile(file);
        System.out.println("После чтения 1");
        System.out.println(pupil1.equals(pupilFromFile));
        Pupil pupilFromFile2 = (Pupil) getObjectFromFile(file);
        System.out.println("После чтения 2");
        System.out.println(pupil2.equals(pupilFromFile2));
    }

    private static void objectToFile(File file, Object obj){
        try(FileOutputStream fileOutputStream = new FileOutputStream(file,true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(obj);
        } catch (FileNotFoundException ignored){

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static Object getObjectFromFile(File file){
        Object obj = null;
        try(FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ){
        obj = objectInputStream.readObject();
        }
        catch (FileNotFoundException e){
            System.out.println("Файл file не найден");
        } catch (IOException e){
            System.out.println("Проблема с чтением");
        } catch (ClassNotFoundException e) {
            System.out.println("Класс не найден");
        }
        return obj;
    }


}
