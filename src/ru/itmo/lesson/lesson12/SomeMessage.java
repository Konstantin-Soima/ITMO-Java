package ru.itmo.lesson.lesson12;

public class SomeMessage {
    private String title;
    private String text;

    public SomeMessage(String title, String text) throws ChatException{
    setText(text);
    setTitle(title);
    //eсли в Title будет исключение конструктор не создаст обьект
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws ChatException{
        if (title.length()<3){
            throw new ChatException("Длинна должна быть больше 3");
        }
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
