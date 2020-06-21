package courseProject.server;

import courseProject.client.Message;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Writer extends Worker {
    Map<Socket, ObjectOutputStream> streamMap = new WeakHashMap<>();
    @Override
    protected void loop() throws Exception {
        Message msg = MainServer.messagesPool.take();
        for (Socket socket : MainServer.userSet){
            ObjectOutputStream outputStream;
            if (streamMap.containsKey(socket)){
                outputStream = streamMap.get(socket);
            } else {
                outputStream = new ObjectOutputStream(socket.getOutputStream());
                streamMap.put(socket,outputStream);
            }

            outputStream.writeObject(msg);
            outputStream.flush();
        }
    }
}
