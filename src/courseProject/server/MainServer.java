package courseProject.server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.LinkedBlockingDeque;

import courseProject.client.Message;

public class MainServer {


    public static  LinkedBlockingDeque<Message> messagesPool= new LinkedBlockingDeque<>(200);//Пул сообщений
    public static  Set<Socket> userSet =  new HashSet<>();    //Пул клиентов
    public static  Map<Socket, String> nicknameMap = new WeakHashMap<>();
    //TODO: Убрать статику

    public static void main(String[] args) {
        int port = 8090;
        try {
            try(ServerSocket serverSocket = new ServerSocket(port)){
                System.out.println("Сервер запущен...");
                new Thread(new Writer()).start(); //Инициализируем рассылку сообщений
                while (true){
                    Socket clientSocket = serverSocket.accept();
                    userSet.add(clientSocket);
                    new Thread(new Reader(clientSocket)).start();
                    //создаём отдельный поток чтения для каждого нового клиента
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
