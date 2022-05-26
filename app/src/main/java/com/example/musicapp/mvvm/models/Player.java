package com.example.musicapp.mvvm.models;
/**
 * Класс "Игрок"
 */
public class Player {
    private int id;
    private String name;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

