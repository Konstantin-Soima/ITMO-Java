package courseProject.client;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;

public class Reader implements Runnable {

    private Socket socket;
    private ObjectInputStream inputStream;

    public Reader(Socket socket) {
       this.socket = socket;
    }

    @Override
    public void run() {
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());

            while (true) {
                try {
                    Message msg = (Message) inputStream.readObject();
                    System.out.println(msg);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (SocketException e){
            System.out.println("Сокет закрыт");
        } catch (EOFException e){
            System.out.println("Обрыв связи с сервером");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
