package com.example.amandaspolti.telasminhas;

/**
 * Classe responsável pelo Item.
 */
public class Item {
    private long _id;
    private boolean done;
    private String text;
    private String dueDate;
    private int nivel; //1 facil 2 medio 3 dificil


    Item() {
    }

    Item(String text, String data, int nivel) {
        this.text = text;
        dueDate = data;
        done = false;
        this.nivel = nivel;
    }


    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = Boolean.parseBoolean(String.valueOf(done));
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
