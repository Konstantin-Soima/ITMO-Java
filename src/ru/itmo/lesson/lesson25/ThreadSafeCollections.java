package ru.itmo.lesson.lesson25;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

public class ThreadSafeCollections {
    public static void main(String[] args) {
        //Vector
        //Stack
        //HasTable - для однопоточной среды их не используйте, в многопоточных тоже вредно из-за блока synhornized

        //однопоточные коллекции и мапы
        ArrayList<String> strings = new ArrayList<>();
        List<String> stringList = Collections.synchronizedList(strings);
        Set<Integer> integerSet = Collections.synchronizedSet(new HashSet<>());
        Map<String, Integer> stringIntegerMap = Collections.synchronizedMap(new HashMap<>());

        //потокобезопасные коллекции и мапы из пакетв java.util.concurrent.*
        CopyOnWriteArrayList<Book> books = new CopyOnWriteArrayList<>();
        // на каждую операцию добавления и удаления создаётся копия
        books.addIfAbsent(new Book("Java",1800));
        books.addIfAbsent(new Book("Java",1800));

        new Thread(new WriteThread(books)).start();
        new Thread(new ReadThread(books)).start();

        CopyOnWriteArraySet s;
        ConcurrentSkipListSet s1;

        ConcurrentHashMap m1;
        ConcurrentSkipListSet m2;
    }
}


class Book{
    private String title;
    private int pageCount;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (pageCount != book.pageCount) return false;
        return getTitle() != null ? getTitle().equals(book.getTitle()) : book.getTitle() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + pageCount;
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }

    public static Book getBook(){
        Random random = new Random();
        String[] titles = {"Алфавит", "Сказки", "Колобок", "Репка"};
        return new Book(titles[random.nextInt(titles.length)],
                random.nextInt(2000)); // до 2000 страниц
    }
}

class WriteThread implements Runnable{
    private CopyOnWriteArrayList<Book> books;

    public WriteThread(CopyOnWriteArrayList<Book> books){
        this.books = books;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++){
            try {
                Thread.sleep(4000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            books.addIfAbsent(Book.getBook());
        }
    }
}
class ReadThread implements Runnable{
    private  CopyOnWriteArrayList<Book> books;

    public ReadThread(CopyOnWriteArrayList<Book> books){
        this.books = books;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("Введите название книги");
            String title = scanner.nextLine();
            for (Book book: books){
                if (title.equalsIgnoreCase(book.getTitle())){
                    System.out.println(book);
                    books.remove(book);
                }
            }
        }
    }
}