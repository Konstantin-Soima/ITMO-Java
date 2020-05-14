package ru.itmo.lesson.lesson18;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class IOlesson {
    public static void main(String[] args) {
        //IO API (java.io)
        //Методами класса File можно создавать/удалять файла/дириктории
        File file = new File("filepath.txt");
        try {
            System.out.println(file.createNewFile());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        //возврат абсолютного пути
        System.out.println(file.getAbsolutePath());
        //Возврат директории
        System.out.println(file.isDirectory());
        //Доступен для чтения
        System.out.println(file.canRead());
        //доступен для записи
        System.out.println(file.canWrite());
        System.out.println(file.length());
        //если данные передаются из программы в виде последовательности байт , то мы должны работать с
        //OutputStream
        //Если в программу - InputStream
        try {
            writeToFile(file,"hello",false);
            writeToFileWithBuffer(file);
            byte[] bytes = imgToByteArray(new File("sources/гитарки.jpg"));
            byteArrayToImage(new File("sources/new.png"),bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void writeToFile(File file, String data, boolean append) throws IOException{
        //File - по тому что с файлом, Output - по тому что исходящий
        //try-with-resource - доступен с java 7 и нужен для автозакрытия ресурсов
        try (FileOutputStream stream = new FileOutputStream(file,append)){
            byte[] bytes = data.getBytes();
            stream.write(bytes);
//        }  catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        finally {
//
        }

    }
    private static void writeToFileWithBuffer(File file) throws IOException{
        // file <---[buffer] <---- java app
        try (FileOutputStream stream = new FileOutputStream(file);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(stream)) {
            //размер буфера 8192 байта, меняется через конструктор  BufferedOutputStream(stream, size)
            for (int i  = 0; i<1_000_000; i++){
                bufferedOutputStream.write((i + " ").getBytes());
            }

        }
    }

     public static String readFromFileToByteArray(File file) throws IOException{
        String string = null;

        try(FileInputStream inputStream = new FileInputStream(file);
        ByteArrayOutputStream arrOut = new ByteArrayOutputStream()){
            byte[] buf = new byte[512];
            int data;
            while ((data = inputStream.read(buf))>0){
                System.out.println(data);
                System.out.println(Arrays.toString(buf));
                arrOut.write(buf,0,data);
            }
            string = new String(arrOut.toByteArray());
        }

        return string;
     }

     public static  byte[] imgToByteArray(File file) throws IOException{
         BufferedImage image = ImageIO.read(file);
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
         ImageIO.write(image,"png",outputStream);
         return outputStream.toByteArray();
     }

     public  static  boolean byteArrayToImage(File file, byte[] bytes) throws IOException {
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes)){
            BufferedImage image = ImageIO.read(inputStream);
            return ImageIO.write(image,"png",file);
        }
     }
}
