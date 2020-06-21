package courseProject.client;


import java.util.Scanner;

public class Chat {
    public static void main(String[] args) {

        int port = 8090; //TODO: Все настройки в .properties файл
        String ip = "188.242.232.214";
        try {
            //основной поток
            Client client = new Client(ip,port);
            new Thread(new Reader(client.getSocket())).start(); //поток чтения
            client.start();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
