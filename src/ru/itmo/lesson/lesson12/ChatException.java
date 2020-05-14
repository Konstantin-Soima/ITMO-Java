package ru.itmo.lesson.lesson12;

// RuntimeException если хотим необрабатываемое
public class ChatException extends Exception{

    public ChatException(String message){
        super(message);
    }
    //Можем переопределять родителя
    @Override
    public String getMessage() {
        return super.getMessage()+" Следите за кодом";
    }
}
