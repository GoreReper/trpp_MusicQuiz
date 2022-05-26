package com.example.musicapp.mvvm.models;
/**
 * Класс "Сессия"
 */
public class Session {


    private int players;
    private int rounds;
    private int time;
    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Session(int theme, int players, int rounds, int time) {
        this.players = players;
        this.rounds = rounds;
        this.time = time;
    }
}
