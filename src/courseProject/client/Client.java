package courseProject.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String ip;
    private int port;
    private Scanner scanner;
    private Socket socket;
    private ObjectOutputStream outputStream;

    public Client(String ip,int port) throws IOException {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
        socket = new Socket(ip, port);


    }

    public Socket getSocket() {
        return socket;
    }

    private void sendMessage(Message message) throws Exception {
        message.setDateMessageCrate();
        outputStream.writeObject(message);
        outputStream.flush();
    }


    public void start() throws Exception{
        System.out.println("Ведите имя:");
        String username = scanner.nextLine();
        String text;
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Добро пожаловать в чат, для выхода введите :exit");
        while (true){
            System.out.println("Введите текст сообщения:");
            text = scanner.nextLine();
            if (":exit".equals(text)){
                outputStream.close();
                socket.close();
                break;
            }
            Message message = new Message(text,username);
            //тут будет отправка
            sendMessage(message);
            System.out.println("Сообщение отправленно в: "+message.getDateMessageCrate());
        }
    }
}
