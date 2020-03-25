package ru.itmo.lesson.lesson6;

public class Book {
    //книги:
    //  Название
    //  Кол-во страниц
    //  Автор (имя фамилия)
    //  можно ли брать домой
    //  доступна ли для выдачи
    private String title;
    private int pageCount;
    private Author author;
    private boolean isForHome; //принято начинать с is
    private boolean isInLibary;

    public Book(){
    }

    public Book(String title) {
        this.title = title;
    }

    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public boolean isForHome() {
        return isForHome;
    }

    public void setForHome(boolean forHome) {
        isForHome = forHome;
    }

    public boolean isInLibary() {
        return isInLibary;
    }

    public void setInLibary(boolean inLibary) {
        isInLibary = inLibary;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                ", author=" + author +
                ", isForHome=" + isForHome +
                ", isInLibary=" + isInLibary +
                '}';
    }
}
