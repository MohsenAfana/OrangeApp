package com.dev.orangeapp.Models;


import java.io.Serializable;

public class TvChannels implements Serializable {

    private int id ;
    private  String name ;
    private int number;
    private int tvGenreId;
    private int nginxSecureLink;

    public TvChannels() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTvGenreId() {
        return tvGenreId;
    }

    public void setTvGenreId(int tvGenreId) {
        this.tvGenreId = tvGenreId;
    }

    public int getNginxSecureLink() {
        return nginxSecureLink;
    }

    public void setNginxSecureLink(int nginxSecureLink) {
        this.nginxSecureLink = nginxSecureLink;
    }
}
