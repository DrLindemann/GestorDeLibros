package org.example;

public class Libro {

    private int id;
    private String title;
    private boolean readed;

    public Libro() {
    }

    public Libro(int id, String title, boolean readed) {
        this.id = id;
        this.title = title;
        this.readed = readed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isReaded() {
        return readed;
    }

    public void setReaded(boolean readed) {
        this.readed = readed;
    }
}
