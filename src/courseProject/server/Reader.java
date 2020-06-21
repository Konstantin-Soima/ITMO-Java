package courseProject.server;


import courseProject.client.Message;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Reader extends Worker {

    private ObjectInputStream inputStream;
    private Socket socket;
    private String currentNickname = "anonymous";

    public Reader(Socket clientSocket) {
        this.socket = clientSocket;
    }

    @Override
    protected void init() throws IOException {
        inputStream = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    protected void loop()  {
        try {
            Message clientMessage = (Message) inputStream.readObject();
            System.out.println(clientMessage);
            MainServer.messagesPool.put(clientMessage);
            if (!currentNickname.equals(clientMessage.getSender())) {
                currentNickname = clientMessage.getSender();
                MainServer.nicknameMap.put(socket, currentNickname);
            }
        } catch (EOFException e){
             try {
                 stop();
             } catch (IOException ex) {
                 ex.printStackTrace();
             }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void stop() throws IOException {
        socket.close();
        System.out.println("Пользователь "+currentNickname+" покинул чат");
        MainServer.userSet.remove(socket);
        System.gc();
        try {
            super.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
