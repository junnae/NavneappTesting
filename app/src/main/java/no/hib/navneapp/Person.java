package no.hib.navneapp;

/**
 * Created by caese_000 on 28.01.2015.
 */
public class Person {
    String name;
    int picture;

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Person(String name, int picture) {
        this.name = name;
        this.picture = picture;
    }

    @Override
    public String toString() {
        return name;
    }
}
