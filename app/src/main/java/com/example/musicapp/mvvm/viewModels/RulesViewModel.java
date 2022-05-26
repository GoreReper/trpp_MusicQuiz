package com.example.musicapp.mvvm.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.musicapp.mvvm.repository.SessionRepository;

public class RulesViewModel extends ViewModel {

    public void newSession(int rounds,int time, int players){
        SessionRepository.session.setRounds(rounds);
        SessionRepository.session.setTime(time);
        SessionRepository.session.setPlayers(players);


    }


}
