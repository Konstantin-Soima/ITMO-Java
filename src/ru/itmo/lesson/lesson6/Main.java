package ru.spbexp.lesson.lesson6;
//правила нотации: доменн наоборот.проек.пакеты
public class Main {
    //библиотека:
    //  можно добавлять книги по 1й или несколько сразу
    //  можно взять книгу (указав автора)
    //  домой / для чтоения в библиотек
    //книги:
    //  Название
    //  Кол-во страниц
    //  Автор (имя фамилия)
    //  можно ли брать домой
    //  доступна ли для выдачи
    public static void main(String[] args) {
        Author author1 = new Author();
        /*author1.name = "Брюс";
        System.out.println(author1.name);*/
        //вызов метода
        author1.setName("Брюс");
        author1.setSurename("Эккель");
        System.out.println(author1.getName());
        Author author2 = new Author();
        /*author2.name = "Роберт";
        System.out.println(author2.name);*/
        author2.setName("Роберт");
        author2.setSurename("Мартин");
        String name = author2.getName();
        System.out.println(name);
        System.out.println(author2);

        Book book1 = new Book("Философия Java");
        book1.setPageCount(1350);
        book1.setAuthor(author1);
        book1.setForHome(true);

        System.out.println(book1);
        Book book2 = new Book("Чистый код", 500);
        book2.setAuthor(author2);
        System.out.println(book2);

        String book1AuthorName = book1.getAuthor().getName();
        System.out.println(book1AuthorName);
        //ссылочные типы по умолчанию null
        //числа - 0
        //булеан - false
        //плавуящая точка 0.0

        Book[] books = {book1, book2};
        // фамилия автора для каждой книги
        for (Book book: books) {
            System.out.println(book.getAuthor().getSurename());
        }

        Library library = new Library();
        library.addBook(book1, book2);


    }
}
