package com.example.musicapp.mvvm.models;


import android.media.MediaPlayer;
import android.view.View;

import com.example.musicapp.R;


public class Song {
    private int id;
    private String author;
    private String name;
    private int music;

    public int getMusic() {
        return music;
    }

    public void setMusic(int music) {
        this.music = music;
    }

    public Song(int id, String author, String name, int music) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.music = music;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
