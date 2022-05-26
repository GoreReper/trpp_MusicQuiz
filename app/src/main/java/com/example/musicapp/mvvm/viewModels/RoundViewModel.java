package com.example.musicapp.mvvm.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.musicapp.mvvm.repository.PlayersRepository;
import com.example.musicapp.mvvm.repository.SessionRepository;

import com.example.musicapp.mvvm.repository.SongRepository;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class RoundViewModel extends ViewModel {
    public SongRepository songRepo = new SongRepository();
    ArrayList<Integer> correctQueue;

    public PlayersRepository playersRepo = new PlayersRepository();
    public int time = 0;
    public boolean FINISH = false;
    public int  currentRound = -1;
    ArrayList<Integer> roundQueue ;
    Random rand = new Random();

    public int[] points = {0, 0, 0, 0, 0, 0};
    public int[] places = {1, 2, 3, 4, 5, 6};

    private final MutableLiveData<Integer> music = new MutableLiveData<>();
    private final MutableLiveData<String> question = new MutableLiveData<>();
    private final MutableLiveData<String> firstButt = new MutableLiveData<>();
    private final MutableLiveData<String> secondButt = new MutableLiveData<>();
    private final MutableLiveData<String> thirdButt = new MutableLiveData<>();
    private final MutableLiveData<String> fourthButt = new MutableLiveData<>();







    private final MutableLiveData<Boolean> answer= new MutableLiveData<>();


    private final MutableLiveData<Boolean> finish = new MutableLiveData<>();

    public MutableLiveData<Boolean> getStart() {
        return start;
    }

    private final MutableLiveData<Boolean> start= new MutableLiveData<>();


    public MutableLiveData<Boolean> getFinish() {
        return finish;
    }

    public MutableLiveData<Boolean> getAnswer() {
        return answer;
    }

    public MutableLiveData<Integer> getMusic() {
        return music;
    }

    public MutableLiveData<String> getQuestion() {
        return question;
    }

    public MutableLiveData<String> getFirstButt() {
        return firstButt;
    }

    public MutableLiveData<String> getSecondButt() {
        return secondButt;
    }

    public MutableLiveData<String> getThirdButt() {
        return thirdButt;
    }

    public MutableLiveData<String> getFourthButt() {
        return fourthButt;
    }

    public void generateCorrectQueue(){
        correctQueue = songRepo.generateCorrectQueue();
    }
    public ArrayList<Integer> generateRoundQueue(int currRound){
        ArrayList<Integer> queue = new ArrayList<>();
        boolean check = false;
        for (int i = 0;i<songRepo.getSongs().size();i++){
            queue.add(i);
        }
        Collections.shuffle(queue);
        for (int i = 0;i<4.;i++){
            if (correctQueue.get(currRound).equals(queue.get(i))) {
                check = true;
                break;
            }
        }
        if (!check){
            queue.set(rand.nextInt(3) , correctQueue.get(currRound));
        }
        return  queue;
    }
    public void dialogStart(){
        start.setValue(true);
    }

    public void nextRound(){
        currentRound++;
        roundQueue = generateRoundQueue(currentRound);
        firstButt.postValue(songRepo.getSongById(roundQueue.get(0)).getName());
        secondButt.postValue(songRepo.getSongById(roundQueue.get(1)).getName());
        thirdButt.postValue(songRepo.getSongById(roundQueue.get(2)).getName());
        fourthButt.postValue(songRepo.getSongById(roundQueue.get(3)).getName());
        if (currentRound>= SessionRepository.getRounds()+4){
            finish.setValue(true);
        }

    }
    public void startMusic(){
        music.postValue(songRepo.getSongById(correctQueue.get(currentRound)).getMusic());
    }
    public void answerCheck(int numButton){
        answer.setValue(songRepo.songCheck(roundQueue.get(numButton),correctQueue.get(currentRound)));
    }

    public void generateBotPoints(){
        for (int i = 1; i<6;i++){
            if (Math.random() < 0.7){
                points[i] += (rand.nextInt(SessionRepository.getTime())*10);
            }
        }
    }

    public void generatePlaces(){
        for (int i = 0; i<6;i++){
            if (Math.random() < 0.7){
                points[i] += (rand.nextInt(SessionRepository.getTime())*10);
            }
        }
    }

}
