package homeWorkLesson18;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class HomeWorkIO {
    public static void main(String[] args) {
//        1. Разбить файл (информацию из одного файла записать в 2 разных файла)
//        Склеить файл (информацию из нескольких файлов записать в один файл)
        try {
            separate("sources/new.png", "sources/new.part1.png", "sources/new.part2.png");
            unite("sources/new.part1.png", "sources/new.part2.png", "sources/new_united.png");
        } catch (IOException e){

        }

    }
    private static  void separate (String inputFile, String outputFile1, String outputFile2) throws IOException {
        File file = new File(inputFile);
        int halfFileLength = (int) Math.round(file.length()/2);
        try(FileInputStream inputStream = new FileInputStream(inputFile);
            ByteArrayOutputStream arrOut = new ByteArrayOutputStream()){
            byte[] buf = new byte[512];
            int data;
            while ((data = inputStream.read(buf))>0){
                arrOut.write(buf,0,data);
            }
           // string = new String(arrOut.toByteArray());
        }

    }

    private static  void unite (String inputFile1, String inputFile2, String outputFile){

    }
}
