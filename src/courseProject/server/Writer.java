package courseProject.server;

import courseProject.client.Message;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class Writer extends Worker {
    @Override
    protected void loop() throws Exception {
        Message msg = MainServer.messagesPool.take();
        for (Socket socket : MainServer.userSet){
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(msg);
            outputStream.flush();
        }
    }
}
