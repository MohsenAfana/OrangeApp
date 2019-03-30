package com.dev.orangeapp.Models;

import java.io.Serializable;


public class tv_category implements Serializable {
    private int id;
    private String title;
    private int number;

    public tv_category() {
    }

    public tv_category(int id, String title, int count) {
        this.id = id;
        this.title = title;
        this.number = count;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    
}
