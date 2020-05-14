package ru.itmo.lesson.lesson19.messages;

import java.io.IOException;
import java.net.Socket;
import java.sql.ClientInfoStatus;
import java.util.Scanner;

public class Client {
    private String ip;
    private int port;
    private Scanner scanner;

    public Client(String ip,int port){
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
    }
    private Socket getSocket() throws IOException {
        Socket socket = new Socket(ip, port);
        return socket;
    }
    private void sendAndPrintMessage(SimpleMessage message) throws Exception {
        try (Connection connection = new Connection(getSocket())){
            connection.sendMessage(message);
            SimpleMessage fromServer = connection.readMessage();
            System.out.println("ответ от сервера" + fromServer);
        }
    }


    // /help
    // /count
    // /exit
    // /ping
    public void start() throws Exception{
        System.out.println("Ведите имя");
        String name = scanner.nextLine();
        String text;
        while (true){
            System.out.println("Введите сообщения");
            text = scanner.nextLine();
            sendAndPrintMessage(SimpleMessage.getInstance(name,text));
        }
    }

    public static void main(String[] args) {
            int port = 8090;
            String ip = "188.242.232.214";
            try {
                new Client(ip,port).start();
            }
            catch (Exception e){
                e.printStackTrace();
            }
    }
}
