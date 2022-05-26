package com.example.musicapp.mvvm.repository;

import com.example.musicapp.R;
import com.example.musicapp.mvvm.models.Player;
import com.example.musicapp.mvvm.models.Song;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Отвечает за хранения информации о игроках в сессии
 */

public class PlayersRepository {
    private final ArrayList<Player> players = new ArrayList<>();

    public PlayersRepository() {
        players.add(new Player(0, "You"));
        players.add(new Player(1, "Bot1"));
        players.add(new Player(2, "Bot2"));
        players.add(new Player(3, "Bot3"));
        players.add(new Player(4, "Bot4"));
        players.add(new Player(5, "Bot5"));

    }
    public String getNickById(int id) {
        return players.get(id).getName();
    }


}
