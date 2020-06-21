package courseProject.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

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
                } catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
