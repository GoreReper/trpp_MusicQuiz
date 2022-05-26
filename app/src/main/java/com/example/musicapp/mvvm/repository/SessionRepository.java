package com.example.musicapp.mvvm.repository;

import com.example.musicapp.mvvm.models.Session;

public class SessionRepository {

    public static Session session = new Session(0,0,0,0);
    public static int getTime() {
        return session.getTime();
    }
    public static int getRounds() {
        return session.getRounds();
    }
    public static int getPlayers() {
        return session.getPlayers();
    }
}
