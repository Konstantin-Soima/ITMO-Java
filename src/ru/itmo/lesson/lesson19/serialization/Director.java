package ru.itmo.lesson.lesson19.serialization;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;

public class Director extends Human implements DataOutput {
    private String speech;
    private int rating;

    public Director(String speech) {
        this.speech = speech;
    }

    public Director() {
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Director)) return false;

        Director director = (Director) o;

        return speech != null ? speech.equals(director.speech) : director.speech == null;
    }

    @Override
    public int hashCode() {
        return speech != null ? speech.hashCode() : 0;
    }


    @Override
    public String toString() {
        return "Director{" +
                "speech='" + speech + '\'' +
                ", rating=" + rating +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void writeExternal(ObjectOutput out) throws IOException{
        out.writeUTF(speech);
        out.writeInt(rating);
        out.writeInt(age);
    }

 public void readExternal(ObjectInputStream in) throws  IOException,ClassNotFoundException{
        speech = in.readUTF();
        rating = in.readInt();
        age = in.readInt();
 }

}
