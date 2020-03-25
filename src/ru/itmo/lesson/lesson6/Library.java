package ru.itmo.lesson.lesson6;

//библиотека:
//  можно добавлять книги по 1й или несколько сразу
//  можно взять книгу (указав автора)
//  домой / для чтоения в библиотек
public class Library {
    private String name = "Библиотека";
    private Book[] books = new Book[5];

    public String getName() {
        return name;
    }

    //добовление 1 книеи
    public void addBook(Book bewBook){
        for (int i = 0; i < books.length; i++) {
            if (books[i]==null){
                bewBook.setInLibary(true);
                books[i]=bewBook;
                return;
            }
        }
    }
    //добавление нескольких книг
    public void addBook(Book ...newBooks){ //... сколько угодно через запятую, а хранится в массиве
        for (Book book: newBooks) {
            for (int i = 0; i < books.length; i++) {
                if (books[i]==null){
                    book.setInLibary(true);
                    books[i]=book;
                    break;
                }
            }
        }
    }

    public Book getHome(String title){
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && title.equals(books[i].getTitle())){
                if (books[i].isForHome() && books[i].isInLibary()) {
                    books[i].setInLibary(false);
                    return books[i];
                }
            }
        }
        return null;
    }
}
