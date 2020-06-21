package courseProject.client;

import ru.itmo.lesson.lesson19.messages.SimpleMessage;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    //коды вывода цветов в консоль
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RESET = "\u001B[0m";

    private LocalDateTime dateMessageCrate;
    private String textMessage;

    public String getSender() {
        return sender;
    }

    // private String receiver;
    private String sender;
   // private String fileName;//имя файла
  //  private byte[] bytes;//содержимое файла

    public Message(String textMessage, String sender) {
        this.textMessage = textMessage;
        this.sender = sender;
    }

//    public String getFileName() {
//        return fileName;
//    }
//
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
//
//    public String getReceiver() {
//        return receiver;
//    }
//
//    public void setReceiver(String receiver) {
//        this.receiver = receiver;
//    }
//
//    public byte[] getBytes() {
//        return bytes;
//    }
//
//    public void setBytes(byte[] bytes) {
//        this.bytes = bytes;
//    }

    public void setDateMessageCrate() {
        this.dateMessageCrate = LocalDateTime.now();
    }

    public static Message getInstance(String text, String sender){
        return new Message(text,sender);
    }

    @Override
    public String toString() {
        return ANSI_GREEN + this.sender + "\t" + ANSI_CYAN + dateMessageCrate
                + ANSI_RESET + "\n" + this.textMessage  + "\n";
    }
}
