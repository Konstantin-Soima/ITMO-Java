package ru.itmo.lesson.lesson11.enums;

import java.time.LocalDateTime;

public class Article {
    private String title;
    private String text;
    private LocalDateTime dateCreated;

    private Country country; //ссылка на  enum

    Article(String title){
        this.title = title;
        dateCreated =  LocalDateTime.now();
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getText(){
        return  this.text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", dateCreated=" + dateCreated +
                ", country=" + country +
                '}';
    }
}
