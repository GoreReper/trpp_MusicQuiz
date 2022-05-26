package com.example.musicapp.mvvm.repository;

import com.example.musicapp.R;
import com.example.musicapp.mvvm.models.Song;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Отвечает за хранения информации о песнях
 */
public class SongRepository {


    private static final ArrayList<Song> songs = new ArrayList<>();
    public ArrayList<Integer> correctQueue;


    public static void Themes1() {
        songs.clear();
        songs.add(new Song(0, "Dj Shadow", "Six Days", R.raw.djshadow));
        songs.add(new Song(1, "Oppenheimer Analysis ", "The Devil's Dancers", R.raw.devilsdancers));
        songs.add(new Song(2, "Jonathan Bree", "Until We're Done", R.raw.jonathanbree));
        songs.add(new Song(3, "The Lovin' Spoonful ", "Summer in the City", R.raw.lovinspoon));
        songs.add(new Song(4, "Midnight Juggernauts", "Memorium", R.raw.memorium));
        songs.add(new Song(5, "MGMT", "Me and Michael", R.raw.mgmt));
        songs.add(new Song(6, "Mr.Kitty", "Lost Children", R.raw.mrkitty));
        songs.add(new Song(7, "POLO & PAN", "Dorothy", R.raw.poloandpan));
        songs.add(new Song(8, "Vitalic", "Waiting For The Stars", R.raw.vitalic));
        songs.add(new Song(9, "The Guggenheim Grotto", "Wisdom", R.raw.wisdom));

    }
    public static void Themes2() {
        songs.clear();
        songs.add(new Song(0, "Dj Shadow", "Six Days", R.raw.djshadow));
        songs.add(new Song(1, "Oppenheimer Analysis ", "The Devil's Dancers", R.raw.devilsdancers));
        songs.add(new Song(2, "Jonathan Bree", "Until We're Done", R.raw.jonathanbree));
        songs.add(new Song(3, "The Lovin' Spoonful ", "Summer in the City", R.raw.lovinspoon));
        songs.add(new Song(4, "Midnight Juggernauts", "Memorium", R.raw.memorium));


    }
    public ArrayList<Integer> generateCorrectQueue(){
        correctQueue= new ArrayList<>();
        for (int i = 0;i<getSongs().size();i++){
            correctQueue.add(i);
        }
        Collections.shuffle(correctQueue);
        return correctQueue;
    }
    public Song getSongById(int id) {
        return songs.get(id);
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public boolean songCheck(int songId, int correctId){
        return songId == songs.get(correctId).getId();
    }
}


