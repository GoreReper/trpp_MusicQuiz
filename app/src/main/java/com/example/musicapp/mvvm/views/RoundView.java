package com.example.musicapp.mvvm.views;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.musicapp.R;



import com.example.musicapp.mvvm.repository.SessionRepository;
import com.example.musicapp.mvvm.repository.SongRepository;
import com.example.musicapp.mvvm.viewModels.RoundViewModel;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Отвечает за просмотр экранной формы "Раунд"
 */

public class RoundView extends AppCompatActivity {
    Button[] ansButt = new Button[4];
    TextView[] nick = new TextView[6];
    TextView[] points = new TextView[6];
    TextView[] place = new TextView[6];
    TextView songName;
    TextView rounds;
    TextView question;
    RoundViewModel roundVM;
    MediaPlayer songPlay;
    ProgressBar timer;
    Dialog dialog;

    int numButt = 0;
    boolean trying = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round);

        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogroundresult);
        dialog.setCancelable(false);

        ansButt[0] =  findViewById(R.id.firstButton);
        ansButt[1] = findViewById(R.id.secondButton);
        ansButt[2] =  findViewById(R.id.thirdButton);
        ansButt[3] =  findViewById(R.id.fourthButton);


        points[0] = dialog.findViewById(R.id.points0);
        points[1] = dialog.findViewById(R.id.points1);
        points[2] = dialog.findViewById(R.id.points2);
        points[3] = dialog.findViewById(R.id.points3);
        points[4] = dialog.findViewById(R.id.points4);
        points[5] = dialog.findViewById(R.id.points5);

        rounds = findViewById(R.id.rounds);

        place[0] = dialog.findViewById(R.id.place0);
        place[1] = dialog.findViewById(R.id.place1);
        place[2] = dialog.findViewById(R.id.place2);
        place[3] = dialog.findViewById(R.id.place3);
        place[4] = dialog.findViewById(R.id.place4);
        place[5] = dialog.findViewById(R.id.place5);

        nick[0] = dialog.findViewById(R.id.nickname0);
        nick[1] = dialog.findViewById(R.id.nickname1);
        nick[2] = dialog.findViewById(R.id.nickname2);
        nick[3] = dialog.findViewById(R.id.nickname3);
        nick[4] = dialog.findViewById(R.id.nickname4);
        nick[5] = dialog.findViewById(R.id.nickname5);

        songName = dialog.findViewById(R.id.songName);

        question =  findViewById(R.id.question);
        timer = findViewById(R.id.timer);



        roundVM = new ViewModelProvider(this).get(RoundViewModel.class);
        roundVM.generateCorrectQueue();


        roundVM.getMusic().observe(this, music-> {
            songPlay = MediaPlayer.create(this,music);
            songPlay.start();
        });
        roundVM.getFirstButt().observe(this, first-> {
            ansButt[0].setText(first);
        });
        roundVM.getStart().observe(this, start-> {
            if (SessionRepository.getPlayers()<4){
                dialog.findViewById(R.id.slot5).setVisibility(View.INVISIBLE);
            }
            if (SessionRepository.getPlayers()<3){
                dialog.findViewById(R.id.slot4).setVisibility(View.INVISIBLE);
            }
            if (SessionRepository.getPlayers()<2){
                dialog.findViewById(R.id.slot3).setVisibility(View.INVISIBLE);
            }
            if (SessionRepository.getPlayers()<1){
                dialog.findViewById(R.id.slot2).setVisibility(View.INVISIBLE);
            }
            nick[0].setText(roundVM.playersRepo.getNickById(0));
            nick[1].setText(roundVM.playersRepo.getNickById(1));
            nick[2].setText(roundVM.playersRepo.getNickById(2));
            nick[3].setText(roundVM.playersRepo.getNickById(3));
            nick[4].setText(roundVM.playersRepo.getNickById(4));
            nick[5].setText(roundVM.playersRepo.getNickById(5));

            points[0].setText(String.valueOf(roundVM.points[0]));
            points[1].setText(String.valueOf(roundVM.points[1]));
            points[2].setText(String.valueOf(roundVM.points[2]));
            points[3].setText(String.valueOf(roundVM.points[3]));
            points[4].setText(String.valueOf(roundVM.points[4]));
            points[5].setText(String.valueOf(roundVM.points[5]));

            place[0].setText(String.valueOf(roundVM.places[0]));
            place[1].setText(String.valueOf(roundVM.places[1]));
            place[2].setText(String.valueOf(roundVM.places[2]));
            place[3].setText(String.valueOf(roundVM.places[3]));
            place[4].setText(String.valueOf(roundVM.places[4]));
            place[5].setText(String.valueOf(roundVM.places[5]));

            String thisSong = roundVM.songRepo.getSongById((roundVM.songRepo.correctQueue.get(roundVM.currentRound))).getName();
            songName.setText(thisSong);

        });
        roundVM.getSecondButt().observe(this, second-> {
            ansButt[1].setText(second);
        });
        roundVM.getThirdButt().observe(this, third-> {
            ansButt[2].setText(third);
        });
        roundVM.getFourthButt().observe(this, fourth-> {
            ansButt[3].setText(fourth);
        });
        roundVM.getAnswer().observe(this, answer-> {
            if(answer){
                ansButt[numButt].setBackgroundResource(R.drawable.greenshape);
                roundVM.points[0] += (SessionRepository.getTime()-roundVM.time)*10;
            }
            else{
                ansButt[numButt].setBackgroundResource(R.drawable.redshape);

            }
            roundVM.time = SessionRepository.getTime() ;
            ansButt[numButt].setTextColor(getResources().getColor(R.color.white));
        });
        roundVM.getFinish().observe(this, finish-> {
                startActivity(new Intent(this, ResultsView.class));
                finish();
                roundVM.FINISH =true;

        });

            ansButt[0].setOnClickListener(view -> {
                if (trying){
                numButt = 0;
                roundVM.answerCheck(numButt);
                trying = false;
                }
            });
            ansButt[1].setOnClickListener(view -> {
                if (trying){
                numButt = 1;
                roundVM.answerCheck(numButt);
                trying = false;
                }
            });
            ansButt[2].setOnClickListener(view -> {
                if (trying){
                numButt = 2;
                trying = false;
                roundVM.answerCheck(numButt);
                }
            });
            ansButt[3].setOnClickListener(view -> {
                if (trying){
                numButt = 3;
                roundVM.answerCheck(numButt);
                trying = false;
                }
            });
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                 if (roundVM.FINISH){
                     finish();
                 }
                 else if (roundVM.time == 0 ){
                     ansButt[numButt].setBackgroundResource(R.drawable.whiteshape);
                     ansButt[numButt].setTextColor(getResources().getColor(R.color.black));
                     runOnUiThread(new Runnable() {
                         final String round = "Round " + (roundVM.currentRound+2);
                         @Override
                         public void run() {
                             roundVM.nextRound();
                             dialog.hide();
                             if(roundVM.currentRound < SessionRepository.getRounds()+4){
                                 roundVM.startMusic();
                                 rounds.setText(round);
                             }

                         }
                     });
                    timer.setMax(SessionRepository.getTime());
                    timer.setProgress(SessionRepository.getTime());
                     if (roundVM.currentRound != -1) {
                         songPlay.stop();
                         songPlay.release();
                     }
                }
                else if(roundVM.time<= SessionRepository.getTime()){
                    timer.setProgress(SessionRepository.getTime()-roundVM.time);

                }
                else if(roundVM.time==SessionRepository.getTime()+1){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            roundVM.generateBotPoints();
                            roundVM.dialogStart();
                            dialog.show();

                        }
                    });
                }
                else if(roundVM.time==SessionRepository.getTime()+6){
                trying = true;
                roundVM.time = -1;
                }
                roundVM.time++;
            }
        }, 0, 1000);


    }

    public void onBackPressed() {
    }


    protected void onStop() {
        super.onStop();
    }
}
