package courseProject.client;

import ru.itmo.lesson.lesson19.messages.SimpleMessage;

import java.util.Scanner;

public class Chat {
    public static void main(String[] args) {
        //основной поток
        Scanner scanner = new Scanner(System.in);;
        System.out.println("Ведите имя:");
        String username = scanner.nextLine();
        String text;
        while (true){
            System.out.println("Введите текст сообщения:");
            text = scanner.nextLine();
            Message message = new Message(text,username);
            message.setDateMessageCrate();
            //тут будет отправка
            System.out.println(message);
        }
    }

}
